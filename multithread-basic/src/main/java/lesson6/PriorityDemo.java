package lesson6;

public class PriorityDemo {
  public static void main(String[] args) {
    Thread1 threadA = new Thread1("A");
    Thread1 threadB = new Thread1("B");
    Thread1 threadC = new Thread1("C");
    Thread1 threadD = new Thread1("D");
    Thread1 threadE = new Thread1("E");

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
