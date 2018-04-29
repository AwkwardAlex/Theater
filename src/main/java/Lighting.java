import java.util.concurrent.CountDownLatch;

public class Lighting extends Thread {

    private CountDownLatch countDownLatch;

    public Lighting(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            sleep(1000);
            System.out.println("The stage lightens up!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
