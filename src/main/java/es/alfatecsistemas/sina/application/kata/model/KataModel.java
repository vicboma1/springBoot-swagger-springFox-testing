package es.alfatecsistemas.sina.application.kata.model;

public class KataModel {
  private String name;

  public KataModel() { }

  public KataModel(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
