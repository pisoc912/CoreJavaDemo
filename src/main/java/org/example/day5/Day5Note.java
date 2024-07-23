package org.example.day5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Day5Note {
    /*
    1. Future and CompletionFuture
       CompletionFuture: Future interface and CompletionStage interface
                                |                   |
             be easily interacted with thread pool  |
                    Provide some APIs which can make the operation on the thread more flexible
       without any return
           public static void main(String[] args) throws ExecutionException, InterruptedException {
            System.out.println("main thread starts");
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try{
                    System.out.println("child thread start working");
                    Thread.sleep(5000);
                    System.out.println("child thread done");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            future.get();
            System.out.println("main thread ends");
        }

        with return
            public static void main(String[] args) throws ExecutionException, InterruptedException {
            System.out.println("main thread starts");
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                try{
                    System.out.println("child thread start working");
                    Thread.sleep(5000);
                    System.out.println("child thread done");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "child thread is done";
            });

            System.out.println("task result: " + future.get());
            System.out.println("main thread ends");
        }

            private static Integer num = 100;
            public static void main(String[] args) throws ExecutionException, InterruptedException {
                System.out.println("main thread starts");
                CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
                 System.out.println("start adding 50 to number");
                 num += 50;
                 return num;
                }).thenApply(val ->{
                    return val * 2;
                }).thenApplyAsync(val -> val + 100).thenAccept(val -> {
                    System.out.println("this is the last step from main thread");
                    System.out.println("res: "+(val-1));
                });

                System.out.println("task result: " + future.get());
                System.out.println("main thread ends");
            }

        handle exception
            public static void main(String[] args) throws ExecutionException, InterruptedException {
                System.out.println("main thread starts");
                CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                    int res = 1/ 0;
                    System.out.println("add 10 to num");
                    num += 10;
                    return num;
                        }).exceptionally(ex->{
                    System.out.println(ex.getMessage());
                    return 404;
                });

                System.out.println("task result: " + future.get());
                System.out.println("main thread ends");
            }

         public static void main(String[] args) throws ExecutionException, InterruptedException {
            System.out.println("main thread starts");
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                System.out.println("add 10 to num");
                num += 10;
                return num;
            }).handle((val,ex)->{
                System.out.println("get into the handle method");
                if(ex == null){
                    System.out.println("task is done");
                    return num;
                } else {
                    System.out.println("exception thrown" + ex.getMessage());
                    return 400;
                }
            });

            System.out.println("task result: " + future.get());
            System.out.println("main thread ends");
        }

        thenCompose, thenCombine
        allOf, anyOf
     */

    /*
    2. Lock
       Synchronized code block/ method/ static method/ class => keyword
       Lock Interface: ReentrantLock: lock(),unlock(),tryLock(),newCondition();
       ReadWriteLock interface: ReentrantReadWriteLock
            Lock readLock()
            Lock writeLock()

       fair lock VS unfair lock
       fair lock: first-come-first-served policy
        ReentrantLock lock = new ReentrantLock(true); // Fair lock
       unfair lock: don't guarantee any particular access order, possibly bypassing waiting threads

       Dead Lock
       two or more threads are waiting for each other to hold resources.
       1. find the deadlock (in terminal => jps)
       how to prevent?
        Avoid nested locks
        Avoid unnecessary lock
        Use Thread Join() method => ensure a thread has completed its execution before the current thread proceeds.


     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyClass obj = new MyClass();
        obj.method1();
    }
}
class MyClass{


    public void method(){
        synchronized (MyClass.class){
            // TODO
        }
    }

    public synchronized void method1(){

    }
}