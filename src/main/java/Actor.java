import java.util.concurrent.CountDownLatch;

public class Actor extends Thread {

    private CountDownLatch countDownLatch;

    public Actor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            sleep(3000);
            System.out.println("Actor enters the stage!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
