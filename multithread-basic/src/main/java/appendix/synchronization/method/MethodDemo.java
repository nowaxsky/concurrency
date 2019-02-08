package appendix.synchronization.method;

public class MethodDemo {

  public static void main(String[] args) {
    ThreadSyn thread = new ThreadSyn();
    Thread thread1 = new Thread(thread, "A");
    Thread thread2 = new Thread(thread, "B");
    thread1.start();
    thread2.start();
  }
}
