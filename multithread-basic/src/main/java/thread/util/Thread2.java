package thread.util;

import java.util.Date;

public class Thread2 extends Thread {
  
  private String name;

  public Thread2(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println(new Date() + " " + name + " start running!");
    try {
      sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(new Date() + " " + name + " stop!");
  }

}
