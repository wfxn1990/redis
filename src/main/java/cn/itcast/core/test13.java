package cn.itcast.core;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test13 {
    private volatile static int num = 0;
   private static Lock lock = new ReentrantLock();
    public  static void add() {

        lock.lock();
        try {
            num++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();

                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(num);
    }
}
