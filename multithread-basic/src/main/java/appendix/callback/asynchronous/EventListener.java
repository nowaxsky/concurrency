package appendix.callback.asynchronous;

public class EventListener implements Listener {

  @Override
  public void onEvent() {
    System.out.println("Performing callback after Asynchronous Task");
    // perform some routine operation
  }
  // some class A methods

}
