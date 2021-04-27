package cn.itcast.core;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class duo1 {
    public static class dayin {
        int number = 1;
        Lock lock = new ReentrantLock();
         Condition c1 = lock.newCondition();
         Condition c2 = lock.newCondition();
         Condition c3 = lock.newCondition();

        public  void print5() throws InterruptedException {
            lock.lock();

            try {
                while (number != 1) {
                    c1.await();
                }
                for (int i = 1; i <= 5; i++) {
                    System.out.println(i);
                }
                number = 2;
                c2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        public void print10() throws InterruptedException {
            lock.lock();

            try {
                while (number != 2) {
                    c1.await();
                }
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                }
                number = 3;
                c3.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        dayin day = new dayin();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        day.print5();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        day.print10();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"B").start();
    }

}
