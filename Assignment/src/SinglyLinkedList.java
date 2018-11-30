public class SinglyLinkedList {
    private final int DEFAULT_MAXIMUM = 10;
    private SLLNode[] listArray;
    private int first;
    private int firstFree;

    public SinglyLinkedList() {
        this.listArray = new SLLNode[DEFAULT_MAXIMUM];
        this.first = 0;
        this.firstFree = 0;
    }

    public SinglyLinkedList(int size) {
        this.listArray = new SLLNode[size];
        this.first = 0;
        this.firstFree = 0;
    }

    public void insert(Packet data) throws ListOverFlowException{
        //the value of first free is -1,which indicates the SLL is full, throw the ListOverFlowException
        if (firstFree == -1) {
            throw new ListOverFlowException();
        }

        listArray[firstFree] = new SLLNode(data);
        SLLIterator iterator = getIterator();

        //move the pointer
        while (iterator.hasNext()) {
            iterator.next();
        }

        //judge if it is the first element of the SLL
        if (first != firstFree) {
            listArray[iterator.getCurrentPosition()].setNext(firstFree);
        }

        //update the value of first free index
        findFirstFree();
    }

    public boolean remove(int messageNumber, int packetNumber) {
        SLLIterator iterator = getIterator();

        //judge if the remove value is the first value in the list array
        if (iterator.getCurrentPosition() == this.first
                && listArray[first].getData().getMessageNumber() == messageNumber
                && listArray[first].getData().getPacketNumber() == packetNumber) {
            this.firstFree = this.first;
            this.first = listArray[first].getNext();
            iterator.remove();
            compactArray();
            return true;
        }

        //if the remove value is not the first value, move the pointer
        while (iterator.hasNext()) {
            //record the current address and move the pointer, then it becomes the previous address
            int previousPosition = iterator.getCurrentPosition();
            Packet temp = iterator.next();

            if (temp.getPacketNumber() == packetNumber
                    && temp.getMessageNumber() == messageNumber) {
                int nextPosition = listArray[iterator.getCurrentPosition()].getNext();
                this.listArray[previousPosition].setNext(nextPosition);
                iterator.remove();
                findFirstFree();
                compactArray();
                return true;
            }
        }

        //this value is not involved in this array, return false
        return false;
    }

    @Override
    public String toString() {
        String string = "first = " + first + "\n"
                + "firstFree = " + firstFree + "\n\n";
        for (int i = 0; i < listArray.length; i++) {
            if (listArray[i] == null) {
                string += "{" + i + ": null}\n";
            } else {
                string += "{" + i + ": {data: " + listArray[i].getData().toString() + " {next: " + listArray[i].getNext() + "}}\n";
            }
        }

        return string;
    }

    public SLLIterator getIterator() {
        return new SLLIterator(first, listArray);
    }

    //this is a method to update the value of first free
    public void findFirstFree() {
        int value_count = 0;
        for (int i = 0; i < listArray.length; i++) {
            if (listArray[i] == null) {
                firstFree = i;
                break;
            } else {
                value_count++;
            }
        }

        //if the SLL is full, set the value of first free -1
        if (value_count == listArray.length) {
            firstFree = -1;
        }
    }

    //this is the method to compact the SLL
    public void compactArray() {
        //get the size of array
        int size = 0;
        for (int i = 0; i < listArray.length; i++) {
            if (null != listArray[i]) {
                size++;
            }
        }

        //if size is bigger than first free, it indicates that there are some vacancies in the previous array
        while (size > firstFree) {
            SLLIterator iterator = getIterator();
            while (iterator.hasNext()) {
                int previousPosition = iterator.getCurrentPosition();
                iterator.next();
                int currentPosition = iterator.getCurrentPosition();
                if (currentPosition >= size) {
                    listArray[previousPosition].setNext(firstFree);
                    listArray[firstFree] = listArray[currentPosition];
                    listArray[currentPosition] = null;
                    findFirstFree();
                    break;
                }
            }
        }
    }
}