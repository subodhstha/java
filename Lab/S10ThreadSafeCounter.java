// 10. Create a program where multiple threads update a shared counter. Use
// synchronization to ensure thread-safe operations.
class Counter {
    private int count = 0;

    // Synchronized method to increment the counter
    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " incremented counter to: " + count);
    }

    // Method to get the current counter value
    public synchronized int getCount() {
        return count;
    }
}

class CounterThread extends Thread {
    private final Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) { // Each thread increments the counter 5 times
            counter.increment();
            try {
                Thread.sleep(100); // Simulate some delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class S10ThreadSafeCounter {
    public static void main(String[] args) {
        Counter sharedCounter = new Counter();

        // Create multiple threads
        Thread thread1 = new CounterThread(sharedCounter);
        Thread thread2 = new CounterThread(sharedCounter);
        Thread thread3 = new CounterThread(sharedCounter);

        // Start the threads
        thread1.setName("Thread 1");
        thread2.setName("Thread 2");
        thread3.setName("Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Print final counter value
        System.out.println("Final counter value: " + sharedCounter.getCount());
    }
}
