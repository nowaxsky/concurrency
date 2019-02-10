package lesson5;

import thread.util.Thread1;

public class JoinDemo {

  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getName().toUpperCase() + " thread starts!");
    Thread1 threadA = new Thread1("A");
    Thread1 threadB = new Thread1("B");

    threadB.start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }
    threadA.start();
    try {

      // 主執行緒等待呼叫的執行緒完成後才會繼續執行, 這裡即等待B完成
      System.out.println(Thread.currentThread().getName().toUpperCase() + " waiting B...");
      threadB.join();
      System.out.println(Thread.currentThread().getName().toUpperCase() + " continues!");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // 由於沒有等待A, 所以主執行緒依然比A更早完成
    System.out.println(Thread.currentThread().getName().toUpperCase() + " thread stops!");
  }

}
