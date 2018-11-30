public class SLLNode {
    private Packet data;
    private int next;

    public SLLNode(Packet data) {
        this.data = data;
        this.next = -1;
    }

    public SLLNode(Packet data, int next) {
        this.data = data;
        this.next = next;
    }

    public Packet getData() {
        return data;
    }

    public void setData(Packet data) {
        this.data = data;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
