import java.util.concurrent.CountDownLatch;

public class RingingBell extends Thread {

    private CountDownLatch countDownLatch;

    public RingingBell(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                sleep(1000);
                System.out.println("The play will begin after " + countDownLatch.getCount() + " rings.");
                sleep(1000);
                ringBell(countDownLatch);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void ringBell(CountDownLatch countDownLatch) {
        System.out.println("Ring!");
        countDownLatch.countDown();
    }
}
