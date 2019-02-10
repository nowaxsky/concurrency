package thread.util;

public class Run2 implements Runnable {

  private String name;

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println("hello " + name);
  }

}
