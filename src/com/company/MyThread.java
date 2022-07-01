package com.company;

import java.util.concurrent.Callable;

class MyThread extends Thread implements Callable<Integer> {
    String name;
    int intervalTime;
    int count;

    public MyThread(String name, int time, int count) {
        this.name = name;
        this.intervalTime = time;
        this.count = count;
    }
//
//    @Override
//    public void run() {
//        try {
//            while(!isInterrupted()) {
//                MyThread.sleep(2500);
//                System.out.printf("Я %s. Всем привет!\n" , getName());
//            }
//        } catch (InterruptedException err) {
//            System.out.println();
//        } finally{
//            System.out.printf("%s завершен\n", getName());
//        }
//    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        try {
            int i = 0;

            while(!(i == count)) {
                i++;
                MyThread.sleep(intervalTime);
                System.out.printf("Я %s. Всем привет!\n" , name);
                result++;
            }
        } catch (InterruptedException err) {
            System.out.println();
        } finally{
            System.out.printf("%s завершен\n", name);
        }
        return result;
    }
}