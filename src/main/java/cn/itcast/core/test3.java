package cn.itcast.core;

import java.util.concurrent.CountDownLatch;

public class test3 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i < 7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t离开教室");
                countDownLatch.countDown();
        },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t班长关门走人");
    }

    /*public static void closedoor() {
        for (int i = 1; i < 7; i++) {
            new Thread(() -> System.out.println(Thread.currentThread().getName() + "\t离开教室"),String.valueOf(i)).start();
        }
        System.out.println(Thread.currentThread().getName()+"\t班长关门走人");
    }*/
}
