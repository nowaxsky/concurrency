package lesson8;

public class Notifier2 implements Runnable {

  private Message msg;

  public Notifier2(Message msg) {
    this.msg = msg;
  }

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    System.out.println(name + " started");
    try {
      Thread.sleep(1000);
      synchronized (msg) {
        msg.setMsg(name + " Notifier work done");
        // msg.notify();
        msg.notifyAll();
        System.out.println(name + " stopped");
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
