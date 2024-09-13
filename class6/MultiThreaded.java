public class MultiThreaded {
    public static void main(String[] args) {
        System.out.println("Main thread is " + Thread.currentThread().getName());
        
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new MultiThreaded().new RunnableImpl());
            t.start();
        }
    }

    private class RunnableImpl implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName() + ", executing run() method");
        }
    }
}