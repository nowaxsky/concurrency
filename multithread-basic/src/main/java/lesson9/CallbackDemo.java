package lesson9;

public class CallbackDemo {

  public static void main(String[] args) {
    Work work = new Work();
    Thread thread = new CallBackThread(work);
    thread.start();
    System.out.println(work.getData());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(work.getData().value);
  }

}
