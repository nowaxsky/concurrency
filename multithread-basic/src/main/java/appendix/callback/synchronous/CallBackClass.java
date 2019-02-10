package appendix.callback.synchronous;

public class CallBackClass {

  // listener field
  private Listener listener;

  // setting the listener
  public void registerEventListener(Listener mListener) {
    this.listener = mListener;
  }

  // My Asynchronous task
  public void doStuff() {

    // perform any operation
    System.out.println("Performing callback before synchronous Task");

    // check if listener is registered.
    if (this.listener != null) {

      // invoke the callback method of class A
      listener.onEvent();
    }
  }

}
