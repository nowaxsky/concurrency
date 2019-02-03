package lesson6;

public class Thread2 extends Thread {

  private String name;

  public Thread2(String name) {
    super(name);
    this.name = name;
  }

  public void run() {
    System.out.println(Thread.currentThread().getName() + " thread starts!");
    for (int i = 0; i < 5; i++) {
      System.out.println("Thread " + name + " run: " + i);
      try {
        sleep((int) Math.random() * 100 + 500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(Thread.currentThread().getName() + " thread stops!");
  }

}
