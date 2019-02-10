package lesson1;

public class Thread1 extends Thread {

  private String name;

  public Thread1(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println(name + " run: " + i);
      try {
        sleep((int) Math.random() * 100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
