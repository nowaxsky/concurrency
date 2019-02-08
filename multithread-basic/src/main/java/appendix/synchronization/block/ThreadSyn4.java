package appendix.synchronization.block;

public class ThreadSyn4 implements Runnable {

  private String name;
  private Object obj;
  
  public ThreadSyn4(String name, Object obj) {
    this.name = name;
    this.obj = obj;
  }
  
  @Override
  public void run() {

    synchronized(obj) {
      for (int i = 0; i < 5; i++) {
        System.out.println("Thread " + name + " run: " + i);
        try {
          Thread.sleep((int) Math.random() * 100 + 500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

}
