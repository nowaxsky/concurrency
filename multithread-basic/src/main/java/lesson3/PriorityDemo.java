package lesson3;

import thread.util.Thread2;

public class PriorityDemo {
  public static void main(String[] args) {
    Thread2 threadA = new Thread2("A");
    Thread2 threadB = new Thread2("B");
    Thread2 threadC = new Thread2("C");
    Thread2 threadD = new Thread2("D");
    Thread2 threadE = new Thread2("E");

    threadA.setPriority(Thread.MIN_PRIORITY); // 1
    threadB.setPriority(2);
    threadC.setPriority(Thread.NORM_PRIORITY); // 5
    threadD.setPriority(8);
    threadE.setPriority(Thread.MAX_PRIORITY); // 10

    threadA.start();
    threadB.start();
    threadC.start();
    threadD.start();
    threadE.start();
  }
}
