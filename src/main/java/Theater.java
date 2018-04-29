import java.util.concurrent.CountDownLatch;

public class Theater extends Thread {

    private CountDownLatch countDownLatch = new CountDownLatch(3);

    private void ringBells() {
        Thread ringingBell = new Thread(new RingingBell(countDownLatch));
        ringingBell.start();
    }

    public void beginPlay() {
        Thread lighting = new Thread(new Lighting(countDownLatch));
        Thread music = new Thread(new Music(countDownLatch));
        Thread actor = new Thread(new Actor(countDownLatch));

        lighting.start();
        music.start();
        actor.start();
        ringBells();
    }

    @Override
    public void run() {
        System.out.println("Theater play is starting, please take your seats.");
        try {
            countDownLatch.await();
            sleep(4000);
            System.out.println("And the play starts!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
