package lesson9;

public class Work {

  private Data data;
  
  public void process(Data data, Integer... numbers) {
    for (int n : numbers) {
      data.value += n;
    }
    this.data = data;
  }
  
  public Data getData() {
    return data;
  }

}
