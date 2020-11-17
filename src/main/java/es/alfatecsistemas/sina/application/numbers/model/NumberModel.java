package es.alfatecsistemas.sina.application.numbers.model;

public class NumberModel<T> {

  private T value;

  public NumberModel() { }
  public NumberModel(final T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public void setValue(final T value) {
    this.value = value;
  }
}
