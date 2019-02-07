package appendix.synchronization.block;

public class CodeBlockDemo3 {

	public static void main(String[] args) {
		ThreadSyn2 thread = new ThreadSyn2();
        Thread thread1 = new Thread(thread,"A");
        Thread thread2 = new Thread(thread,"B");
        thread1.start();
        thread2.start();
	}
}
