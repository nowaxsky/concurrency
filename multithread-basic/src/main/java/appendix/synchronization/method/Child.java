package appendix.synchronization.method;

public class Child extends Parent {

  /*
   * 因為synchronized不是方法定義的一部份, 所以@Override並不會有synchronized
   * 
   * 在Child.method前加了synchronized前綴後, 掛上@Override也不會有錯誤(因為不屬於方法定義)
   * 
   * @see appendix.synchronization.method.Parent#method()
   */
  @Override
  public void method() {

  }
  
  // @Override
  // public synchronized void method() {
  //
  // }
}
