package com.company;

import java.util.TimerTask;

class MyThread extends Thread implements Runnable{
    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    @Override
    public void run() {
        try {
            while(!isInterrupted()) {
                MyThread.sleep(2500);
                System.out.printf("Я %s. Всем привет!\n" , getName());
            }
        } catch (InterruptedException err) {
            System.out.println();
        } finally{
            System.out.printf("%s завершен\n", getName());
        }
    }
}