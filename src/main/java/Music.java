import java.util.concurrent.CountDownLatch;

public class Music extends Thread {

    private CountDownLatch countDownLatch;

    public Music(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            sleep(2000);
            System.out.println("The orchestra starts playing!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
