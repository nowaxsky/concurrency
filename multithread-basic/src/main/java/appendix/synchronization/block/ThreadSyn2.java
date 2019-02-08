package appendix.synchronization.block;

public class ThreadSyn2 implements Runnable {

  private int count = 0;

  @Override
  public void run() {

    String threadName = Thread.currentThread().getName();

    if (threadName.equals("A")) {
      synchronized (this) {
        for (int i = 0; i < 5; i++) {
          try {
            System.out.println(Thread.currentThread().getName() + " count :" + (count++));
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    } else if (threadName.equals("B")) {
      for (int j = 0; j < 5; j++) {
        try {
          System.out.println(Thread.currentThread().getName() + " j :" + j);
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
