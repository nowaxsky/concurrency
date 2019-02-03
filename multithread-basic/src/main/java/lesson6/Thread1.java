package lesson6;

import java.util.Date;

public class Thread1 extends Thread {
  
  private String name;

  public Thread1(String name) {
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
