package queue;

public class Test {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.insert("1");
        queue.insert("2");

        System.out.println(queue.getFront());
    }
}
