package thread.util;

public class Run1 implements Runnable{

  private String name;

  public Run1(String name) {
    this.name = name;
  }
  
  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Runnable " + name + " run: " + i);
      System.out.println("Thread " + Thread.currentThread().getName() + " run: " + i);
      try {
        Thread.sleep((int) Math.random() * 100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
