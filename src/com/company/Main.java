package com.company;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Создаю потоки...");
        MyRunnable runnable = new MyRunnable();
        ThreadGroup myGroup = new ThreadGroup("main group");



        Thread thread1 = new MyThread(myGroup, runnable, "поток 1");
        Thread thread2 = new MyThread(myGroup, runnable, "поток 2");
        Thread thread3 = new MyThread(myGroup, runnable, "поток 3");
        Thread thread4 = new MyThread(myGroup, runnable, "поток 4");
        Thread thread5 = new ThreadKiller(myGroup);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.setDaemon(true);
        thread5.start();

    }
}
