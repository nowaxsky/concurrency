package appendix.callback.asynchronous;

public class CallBackClass {
  
  // listener field
  private Listener listener;

  // setting the listener
  public void registerEventListener(Listener mListener) {
    this.listener = mListener;
  }

  // My Asynchronous task
  public void doStuff() {

    // An Async task always executes in new thread
    new Thread(new Runnable() {
      public void run() {

        // perform any operation
        System.out.println("Performing operation in Asynchronous Task");

        // check if listener is registered.
        if (listener != null) {

          // invoke the callback method of class A
          listener.onEvent();
        }
      }
    }).start();
  }

}
