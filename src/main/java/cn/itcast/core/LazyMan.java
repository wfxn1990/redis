package cn.itcast.core;

public class LazyMan {
    private  static LazyMan lazyMan = null;

    private LazyMan() {
        
    }

    public static LazyMan getInstance() {


                if (null == lazyMan) {
                    lazyMan = new LazyMan();
                }

        return lazyMan;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(lazyMan.getInstance());
                }
            }).start();
        }
    }
}
