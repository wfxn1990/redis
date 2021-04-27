package cn.itcast.core;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class test5 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i < 7; i++) {
            new Thread(() -> {
                try {

                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "\t抢到了车位");
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"\t离开了车位");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
