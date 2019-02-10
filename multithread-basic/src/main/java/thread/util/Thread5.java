package thread.util;

public class Thread5 extends Thread {

  private String name;

  public Thread5(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println("hello " + name);
  }

}
