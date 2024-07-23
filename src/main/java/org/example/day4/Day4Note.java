package org.example.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Day4Note {
    /*
    1. Stream API
        java.util.stream.package
            intermediate operation
            map/filter...
            return stream type
            terminal operation
            collect
            return normal type
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
        List<Integer> res = list.stream().map(e -> e + 1).filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println(res);

        Character[] array = new Character[]{'a','a','b','c'};
        Map<Character,Integer> map = Arrays.stream(array).collect(Collectors.toMap(b->b,b->1,(a,b)->a+b));
        System.out.println(map);

        Map<Character,Integer> map2 = Arrays.stream(array).collect(Collectors.groupingBy(c -> c, Collectors.summingInt(e -> 1)));
        System.out.println(map2);
     */

    /*
    2. Multi-threading
        Thread & Process
        Thread: a smallest unit of a process that can be executed independently.
                independent stack, PC register
        Process: a instance of computer program that is being executed.
                independent memory,stack,heap,os resources

        Thread state
            new -> runnable -> blocked
                            -> waiting
                            -> timed waiting
                            -> terminated

        How to create a thread
        1. extends Thread
            Thread t1 = new MyThread();
            t1.start();
            class MyThread extends Thread{
                @Override
                public void run(){
                    System.out.println(Thread.currentThread().getName() + " thread is created by extending Thread Class");
                }
            }
        2. implement Runnable
            Thread t2 = new Thread(new MyThread1());
            t2.start();
            class MyThread1 implements Runnable{
                @Override
                public void run(){
                    System.out.println(Thread.currentThread().getName() + " thread is created by implementing Runnable interface");
                }
            }
        3. implement Callable
            FutureTask task = new FutureTask<>(new CallableThread());
            Thread t3 = new Thread(task);
            t3.start();
            System.out.println(task.get());

            class CallableThread implements Callable{
                @Override
                public Integer call() throws Exception{
                    System.out.println(Thread.currentThread().getName() + " thread is created by implementing Callable");
                    return 123;
                }
            }
        4. ThreadPool
                public static void main(String[] args) throws ExecutionException, InterruptedException {
                    ExecutorService threadPool = new ThreadPoolExecutor(
                            2,
                            5,
                            2L,
                            TimeUnit.SECONDS,
                            new ArrayBlockingQueue<>(4),
                            Executors.defaultThreadFactory(),
                            new ThreadPoolExecutor.DiscardPolicy()
                    );

                    for(int i  = 1; i <= 10; i++){
                        threadPool.execute(()->{
                            System.out.println(Thread.currentThread().getName() + " is working");
                        });
                    }
                    threadPool.shutdown();
                }
          predefined thread pool
            newFixedThreadPool: Fixed number of threads, queued tasks wait for available threads.
            newSingleThreadExecutor: Single thread, tasks are executed sequentially.
            newCachedThreadPool: Dynamic number of threads, reuses idle threads, suitable for many short tasks.
            newScheduledThreadPool: Fixed number of threads, supports delayed and periodic task execution.

     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService tp1 = Executors.newFixedThreadPool(2);
    }
}

