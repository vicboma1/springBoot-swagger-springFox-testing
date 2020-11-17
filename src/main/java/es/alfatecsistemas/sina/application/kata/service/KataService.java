package es.alfatecsistemas.sina.application.kata.service;

import es.alfatecsistemas.sina.application.kata.model.KataModel;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class KataService {

  public static final String PREFIX = "Hi";

  public KataService() {}

  @PostConstruct
  public void postConstructor(){
  }

  public String response(final KataModel model){
    return PREFIX+" "+model.getName();
  }

  public KataModel responseModel(final KataModel model){
    model.setName(PREFIX+" "+model.getName());
    return model;
  }

}
