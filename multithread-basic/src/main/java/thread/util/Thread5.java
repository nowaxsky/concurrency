package lesson9;

public class Thread1 extends Thread {

  private String name;

  public Thread1(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println("hello " + name);
  }

}
