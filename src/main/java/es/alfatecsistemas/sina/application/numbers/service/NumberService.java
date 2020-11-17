package es.alfatecsistemas.sina.application.numbers.service;

import es.alfatecsistemas.sina.application.numbers.model.NumberModel;

import org.springframework.stereotype.Service;

@Service
public class NumberService {

  public NumberService() {
  }

  public <T> NumberModel toMessage(final T value){
    return new NumberModel<T>(value);
  }

}
