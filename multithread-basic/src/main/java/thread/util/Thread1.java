package thread.util;

public class Thread1 extends Thread {

  private String name;

  public Thread1(String name) {
    super(name);
  }

  @Override
  public void run() {
    // getName()出來的名稱從super(name)而來
    name = Thread.currentThread().getName();

    System.out.println(name + " thread starts!");
    for (int i = 0; i < 5; i++) {
      System.out.println(name + " run: " + i);
      try {
        sleep((int) Math.random() * 100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(name + " thread stops!");
  }
}
