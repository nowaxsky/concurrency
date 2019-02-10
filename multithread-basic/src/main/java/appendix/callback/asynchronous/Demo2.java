package appendix.callback.asynchronous;

public class Demo2 {

  public static void main(String[] args) {
    
    Li li = new Li();
    Wang wang = new Wang(li);

    // 小王問小李問題
    wang.askQuestion("1 + 1 = ?");
  }
}
