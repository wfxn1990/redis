package cn.itcast.core;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class duoXceng {
    static class aircond{
        int number = 0;
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        public void incr() throws Exception {
            lock.lock();
            try {
                while (number != 0) {
                    condition.await();
                }
                number++;
                System.out.println(Thread.currentThread().getName() + "\t" + number);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        public void decr() throws Exception {
            lock.lock();
            try {
                while (number == 0) {
                    condition.await();
                }
                number--;
                System.out.println(Thread.currentThread().getName() + "\t" + number);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
       /* public synchronized void  incr() throws Exception {
            while (number != 0) {
                this.wait();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);

            this.notifyAll();
        }
        public synchronized void  decr() throws Exception {
            while (number == 0) {
                this.wait();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            this.notifyAll();
        }*/
    }
    public static void main(String[] args) {
        aircond air = new aircond();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    air.incr();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    air.decr();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    air.incr();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    air.decr();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
