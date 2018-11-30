public class SLLIterator implements java.util.Iterator<Packet> {
    private int currentPosition;
    private SLLNode[] iteratedListArray;

    public SLLIterator(int firstNode, SLLNode[] listArray) {
        this.currentPosition = firstNode;
        this.iteratedListArray = listArray;
    }

    @Override
    public boolean hasNext() {
        return this.iteratedListArray[this.currentPosition].getNext() != -1;
    }

    @Override
    public Packet next() {
        this.currentPosition = this.iteratedListArray[this.currentPosition].getNext();
        return iteratedListArray[this.currentPosition].getData();
    }

    @Override
    public void remove(){
        this.iteratedListArray[this.currentPosition] = null;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
