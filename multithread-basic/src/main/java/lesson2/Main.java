package lesson2;

import thread.util.Run1;

public class Main {

  public static void main(String[] args) {
    new Thread(new Run1("C")).start();
    new Thread(new Run1("D")).start();
    new Thread(new Run1("E"), "X").start();
    new Thread(new Run1("F"), "Y").start();
  }
}
