package lesson2;

public class Thread2 implements Runnable{

  private String name;

  public Thread2(String name) {
    this.name = name;
  }
  
  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println(name + " run: " + i);
      try {
        Thread.sleep((int) Math.random() * 100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
