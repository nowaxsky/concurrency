package lesson6;

import java.util.Date;

public class Waiter implements Runnable {

  private Message msg;

  public Waiter(Message m) {
    this.msg = m;
  }

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    synchronized (msg) {
      try {
        System.out.println(name + " waiting to get notified at time:" + new Date());
        msg.wait();
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out
          .println(name + " waiter thread got notified at time:" + new Date());
      // process the message now
      System.out.println(name + " processed: " + msg.getMsg());
    }
  }

}
