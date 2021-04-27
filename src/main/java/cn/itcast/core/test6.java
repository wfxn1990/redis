package cn.itcast.core;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCahe {
    private volatile Map<String, Object> map = new HashMap<>();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(String key, Object value) {

        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t写入数据"+key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t读取数据");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读取完成"+result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
public class test6 {
    public static void main(String[] args) {
        MyCahe myCahe = new MyCahe();
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(()->{
                myCahe.put(tempInt+"",tempInt+"");
            },String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(()->{
                myCahe.get(tempInt+"");
            },String.valueOf(i)).start();
        }
    }
}
