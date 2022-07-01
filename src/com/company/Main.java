package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Создаю потоки...");
        ThreadGroup myGroup = new ThreadGroup("main group");

        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        MyThread thread1 = new MyThread( "поток 1", 2000, 5);
        MyThread thread2 = new MyThread( "поток 2", 2500, 6);
        MyThread thread3 = new MyThread( "поток 3", 3000, 4);
        MyThread thread4 = new MyThread( "поток 4", 2700, 6);

        Callable <Integer> myCallable1 = new MyThread( "поток 1", 2000, 5);
        Callable <Integer> myCallable2 = new MyThread( "поток 2", 2500, 6);
        Callable <Integer> myCallable3 = new MyThread( "поток 3", 3000, 4);
        Callable <Integer> myCallable4 = new MyThread( "поток 4", 2700, 6);
        List<MyThread> someTasks = new ArrayList<>();
        someTasks.add(thread1);
        someTasks.add(thread2);
        someTasks.add(thread3);
        someTasks.add(thread4);
        Future<Integer> answer1 = threadPool.submit(myCallable1);
        Future<Integer> answer2 = threadPool.submit(myCallable2);
        Future<Integer> answer3 = threadPool.submit(myCallable3);
        Future<Integer> answer4 = threadPool.submit(myCallable4);
        Integer result1 = answer1.get();
        Integer result2 = answer2.get();
        Integer result3 = answer3.get();
        Integer result4 = answer4.get();
        System.out.println(result1);
        System.out.println((result2));
        System.out.println((result3));
        System.out.println((result4));
        Integer anyResult = threadPool.invokeAny(someTasks);
        threadPool.shutdown();
        System.out.println(anyResult);
//        Thread thread5 = new ThreadKiller(myGroup);
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.setDaemon(true);
//        thread5.start();

    }
}
