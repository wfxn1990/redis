package cn.itcast.core;

public class Hungry {
    private byte[] data1 = new byte[1024 * 1024];

    private Hungry() {

    }

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance() {
        return HUNGRY;
    }

    public static void main(String[] args) {
        Hungry hungry = Hungry.getInstance();
    }
}
