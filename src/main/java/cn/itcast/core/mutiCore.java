package cn.itcast.core;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

interface foo {
    public   int fuuu(int x,int y);
}
public class mutiCore {
   public static class Ticket {
        private int number = 30;
        Lock lock = new ReentrantLock();

        public void sale() {
            lock.lock();
            try {
                while (number > 0) {
                    System.out.println(Thread.currentThread().getName() + "\t卖出第："+(number--)+"\t 还剩下："+number);

                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        thread01(ticket, "A");
        thread01(ticket, "B");
        thread01(ticket, "C");
        foo sss = (x, y) -> 0;
        sss.fuuu(1,2);
    }

    public static void thread01(Ticket ticket, String c) {
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, c).start();
    }


}
