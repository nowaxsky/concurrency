package lesson2;

public class Main {

  public static void main(String[] args) {
    new Thread(new Thread2("C")).start();
    new Thread(new Thread2("D")).start();
  }
}
