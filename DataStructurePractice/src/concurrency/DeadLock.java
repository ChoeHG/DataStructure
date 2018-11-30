package concurrency;

public class DeadLock {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

//        DeadLockThread t1 = new DeadLockThread(obj1, obj2);
//        DeadLockThread t2 = new DeadLockThread(obj2, obj1);

//        t1.start();
//        t2.start();

    }
    class DeadLockThread extends Thread {
        private Object obj1;
        private Object obj2;

        public DeadLockThread(Object obj1, Object obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        public void run() {
            synchronized (obj1) {
                try {
                    Thread.sleep(1000);
                    synchronized (obj2) {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
