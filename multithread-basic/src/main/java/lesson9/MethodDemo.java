package lesson9;

public class MethodDemo {

  public static void main(String[] args) {

    Thread2 myThread = new Thread2();
    myThread.setName("world");
    Thread thread = new Thread(myThread);
    thread.start();
  }
}
