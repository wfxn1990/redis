import java.util.concurrent.TimeUnit;

public class tVolatile {
    private volatile static int num = 0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (num == 0) {

                }
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 1;
        System.out.println("1");
    }
}
