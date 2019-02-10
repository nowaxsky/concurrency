package lesson8;

public class WaitAndNotifyDemo2 {

  public static void main(String[] args) {
    Message msg = new Message("process it");
    Waiter waiter = new Waiter(msg);
    new Thread(waiter, "waiter1").start();

    Waiter waiter1 = new Waiter(msg);
    new Thread(waiter1, "waiter2").start();

    Notifier2 notifier = new Notifier2(msg);
    new Thread(notifier, "notifier2").start();
    System.out.println("All the threads are started");
  }
}
