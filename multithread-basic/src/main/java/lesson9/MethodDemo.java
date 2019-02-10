package lesson9;

import thread.util.Run2;

public class MethodDemo {

  public static void main(String[] args) {

    Run2 myThread = new Run2();
    myThread.setName("world");
    Thread thread = new Thread(myThread);
    thread.start();
  }
}
