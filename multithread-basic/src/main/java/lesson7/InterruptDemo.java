package lesson6;

public class InterruptDemo {

  public static void main(String[] args) {
    Thread4 threadA = new Thread4("A");
    threadA.start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    threadA.interrupt();

  }
}
