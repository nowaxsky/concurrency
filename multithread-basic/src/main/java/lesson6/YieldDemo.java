package lesson6;

public class YieldDemo {

  public static void main(String[] args) {
    
    Thread3 yt1 = new Thread3("A");
    Thread3 yt2 = new Thread3("B");
    yt1.start();
    yt2.start();
  }

}
