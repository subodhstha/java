import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Task class implementing Runnable
class Task implements Runnable {
    public String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task " + name + " is running on " + Thread.currentThread().getName());
            Thread.sleep(2000); // Simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Main class to demonstrate ThreadPoolExecutor
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        // Create a ThreadPoolExecutor with a fixed thread pool of 3 threads
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        // Submit tasks to the executor
        for (int i = 1; i <= 5; i++) {
            Task task = new Task("Task " + i);
            System.out.println("Submitting " + task.name);
            executor.submit(task);
        }

        // Shutdown the executor
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}