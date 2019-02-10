package lesson1;

import thread.util.Thread1;

public class Main {

  public static void main(String[] args) {
    Thread1 th1 = new Thread1("A");
    Thread1 th2 = new Thread1("B");
    Thread1 th3 = th2;  //重複使用產生IllegalThreadStateException錯誤
    th1.start();
    th2.start();
    th3.start();
  }
}
