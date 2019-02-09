package appendix.callback.asynchronous;

/**
 * 小王
 * 
 * class A 實現介面 CallBack
 * 
 * @author Mailu
 *
 */
public class Wang implements CallBack {

  /*
   * class A 中包含一個 class B 的引用 b
   */
  private Li li;

  public Wang(Li li) {
    this.li = li;
  }

  /*
   * 小王通過這個方法問小李問題
   */
  public void askQuestion(final String question) {

    // 使用線程即非同步(異步)
    new Thread(new Runnable() {

      @Override
      public void run() {
        
        System.out.println("問題太難! 先打電話給小李!");
        /**
         * 小王調用小李中的方法
         * 
         * 物件 a 調用 B 的方法 f(CallBack callback) ——A類調用B類的某個方法 C
         */
        li.executeMessage(Wang.this, question);
      }
    }).start();

    // 小王掛掉電話就去逛街了(懶得等小李解, 還做其他事情)
    play();
  }

  public void play() {
    System.out.println("小王繼續逛街!!!");
  }

  /*
   * 小李知道答案後調用此方法告訴小王, 就是所謂的小王的回調方法
   */
  @Override
  public void solve(String result) {
    System.out.println("小王得到答案是: " + result);

  }

}
