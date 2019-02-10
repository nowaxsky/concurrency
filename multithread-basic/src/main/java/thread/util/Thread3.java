package thread.util;

public class Thread3 extends Thread {

  public Thread3(String name) {
    super(name);
  }

  @Override
  public void run() {
    for (int i = 1; i <= 50; i++) {
      System.out.println(this.getName() + "-----" + i);
      
      // 當i為30時, 該線程就會把CPU時間讓掉, 讓其他或者自己的線程執行(也就是誰先搶到誰執行)
      if (i == 30) {
        yield();
      }
    }

  }

}
