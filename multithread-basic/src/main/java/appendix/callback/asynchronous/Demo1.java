package appendix.callback.asynchronous;

public class Demo1 {

  public static void main(String[] args) {
    CallBackClass callBack = new CallBackClass();
    Listener listener = new EventListener();
    callBack.registerEventListener(listener);
    callBack.doStuff();
  }

}
