package appendix.synchronization.staticMethod;

public class StaticMethodDemo {

  public static void main(String[] args) {
    ThreadSyn threadA = new ThreadSyn();
    ThreadSyn threadB = new ThreadSyn();
    Thread thread1 = new Thread(threadA, "A");
    Thread thread2 = new Thread(threadB, "B");
    thread1.start();
    thread2.start();
  }
}
