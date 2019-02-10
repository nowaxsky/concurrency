package appendix.synchronization.block;

public class ThreadSyn implements Runnable {

  private int count = 0;

  @Override
  public void run() {
    synchronized (this) {
      for (int i = 0; i < 5; i++) {
        try {
          System.out.println(Thread.currentThread().getName() + ":" + (count++));
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
