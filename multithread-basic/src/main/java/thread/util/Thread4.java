package thread.util;

import java.util.Date;

public class Thread4 extends Thread {

  private String name;

  public Thread4(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println(new Date() + " " + name + " start running!");
    try {
      sleep(99999);
    } catch (InterruptedException e) {
      System.out.println("I am interrupted...."); 
    } 
    System.out.println(new Date() + " " + name + " stop!");
  }

}
