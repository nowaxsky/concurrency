package lesson9;

import java.util.Random;

public class Thread3 extends Thread {

  private Work work;

  public Thread3(Work work) {
    this.work = work;
  }

  public void run() {
    Random random = new Random();
    Data data = new Data();
    int n1 = random.nextInt(1000);
    int n2 = random.nextInt(2000);
    int n3 = random.nextInt(3000);
    work.process(data, n1, n2, n3); // 使用回调函数
    System.out.println(String.valueOf(n1) + "+" + String.valueOf(n2) + "+" + String.valueOf(n3)
        + "=" + data.value);
  }

}
