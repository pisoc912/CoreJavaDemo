package org.example.day5;

public class DeadLockDemo {
    public static void main(String[] args) {
        final String resource1 = "resource1";
        final String resource2 = "resource2";

        Thread t1 = new Thread(){
            public void run(){
                synchronized (resource1){
                    System.out.println("thread1: locked resource 1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    //thread1 is waiting here.
                    synchronized (resource2){
                        System.out.println("thread1: locked resource 2");
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                synchronized (resource2){
                    System.out.println("thread2: locked resource 2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    // thread2 is waiting here
                    synchronized (resource1){
                        System.out.println("thread2: locked resource 1");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
