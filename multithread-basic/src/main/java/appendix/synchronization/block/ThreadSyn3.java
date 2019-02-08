package appendix.synchronization.block;

public class ThreadSyn3 implements Runnable {

  private byte[] lock = new byte[0]; // 特殊的instance变量

  public void method() {
    synchronized (lock) {
      // todo 同步代码块
    }
  }

  @Override
  public void run() {
    // TODO Auto-generated method stub

  }
}
