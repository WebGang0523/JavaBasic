package com.xucg.thread;

public class Window2Test {
    public static void main(String[] args) {
        Window2 w = new Window2();

        new Thread(w).start();
        new Thread(w).start();
        new Thread(w).start();
    }
}

class Window2 implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (Window2.this) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+ ":" +ticket);
                    ticket--;
                }
            }
        }
    }
}
