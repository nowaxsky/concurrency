package lesson9;

public class Thread2 implements Runnable {

  private String name;

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println("hello " + name);
  }

}
