package com.company;

public class ThreadKiller extends Thread{
    ThreadGroup killedGroup;
    public ThreadKiller (ThreadGroup killedGroup) {
        this.killedGroup = killedGroup;
    }
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(15000);
                killedGroup.interrupt();
                System.out.println("Все потоки закрыты.");
            } catch (InterruptedException err) {
                System.out.println();
            }
        }
    }
}
