package lesson6;

import java.util.Date;

public class SleepDemo {

  public static void main(String[] args) {

    System.out.println(new Date() + " test 1 starts");
    try {
      System.out.println("main sleeping...");
      Thread.sleep(2000);

      // sleep是讓當前的thread暫停工作, 呼叫哪一個thread的sleep都只能暫停"當前"的執行緒
      System.out.println("main sleeping using Thread1...");
      Thread1.sleep(2000);

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(new Date() + " test1 stops");
    System.out.println(new Date() + " test2 starts");

    Thread1 thread1 = new Thread1("A");
    Thread1 thread2 = new Thread1("B");

    // A,B變為可執行態, 由OS決定何時執行, 故有可能B比A早執行
    thread1.start();
    thread2.start();

    try {
      System.out.println("main sleeping...");
      Thread.sleep(2000);
      System.out.println(new Date() + " test2 stops");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
