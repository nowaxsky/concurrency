package appendix.synchronization.staticMethod;

public class ThreadSyn implements Runnable {

  private static int count = 0;

  @Override
  public void run() {
    method();
  }
  
  public static synchronized void method() {
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
