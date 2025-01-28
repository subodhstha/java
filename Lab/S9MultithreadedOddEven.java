// 9. Write a multithreaded program to print numbers from 1 to 10 using two threads,
// where one thread prints odd numbers and the other prints even numbers.

class NumberPrinter {
    private boolean isOddTurn = true;

    // Method to print odd numbers
    public synchronized void printOdd(int number) {
        while (!isOddTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Odd: " + number);
        isOddTurn = false;
        notifyAll();
    }

    // Method to print even numbers
    public synchronized void printEven(int number) {
        while (isOddTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Even: " + number);
        isOddTurn = true;
        notifyAll();
    }
}

class OddThread extends Thread {
    private final NumberPrinter printer;

    public OddThread(NumberPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            printer.printOdd(i);
        }
    }
}

class EvenThread extends Thread {
    private final NumberPrinter printer;

    public EvenThread(NumberPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            printer.printEven(i);
        }
    }
}

public class S9MultithreadedOddEven {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        // Create and start threads
        Thread oddThread = new OddThread(printer);
        Thread evenThread = new EvenThread(printer);

        oddThread.start();
        evenThread.start();
    }
}
