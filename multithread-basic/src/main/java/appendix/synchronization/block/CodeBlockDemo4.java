package appendix.synchronization.block;

public class CodeBlockDemo4 {

  public static void main(String[] args) {
    Object obj = new Object();
    ThreadSyn4 threadA = new ThreadSyn4("A", obj);
    ThreadSyn4 threadB = new ThreadSyn4("B", obj);
    Thread thread1 = new Thread(threadA);
    Thread thread2 = new Thread(threadB);
    thread1.start();
    thread2.start();
  }
}
