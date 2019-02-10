package appendix.callback.asynchronous;

/**
 * 小李
 * 
 * class B 有一個參數為 callback的方法f(CallBack callback)
 * 
 * @author Mailu
 *
 */
public class Li {

  public void executeMessage(CallBack callBack, String question) {
    System.out.println("小李接收到小王問的問題: " + question);

    // 小李在看電影沒空幫忙
    try {
      System.out.println("小李先看電影...");
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("小李先看完電影立刻解出答案");
    // 小李看完電影解出來答案是2
    String result = "2";

    /**
     * 打電話告訴小王
     * 
     * b 就可以在f(CallBack callback)方法中調用 A 的方法 ——B類調用A類的某個方法d
     */
    System.out.println("小李打電話告訴小王答案");
    callBack.solve(result);

  }
}
