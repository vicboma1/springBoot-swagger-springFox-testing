package es.alfatecsistemas.sina.application.kata.controller;

import es.alfatecsistemas.sina.application.kata.model.KataModel;
import es.alfatecsistemas.sina.application.kata.service.KataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.PostConstruct;

@Controller
public class KataController {

  @Autowired
  private KataService kataService;

  public KataController(){ }

  @PostConstruct
  public void PostConstructor() {
  }

  //http://localhost:8080/hi?name=victor
  @GetMapping("/hello")
  @ResponseStatus(HttpStatus.OK)
  public void hello() {
  }

  //http://localhost:8080/hi?name=victor
  @GetMapping(value="/hi")
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public String hi(@RequestParam final String name) {
    return kataService.response(new KataModel((name)));
  }

  //http://localhost:8080/hiPojo?name=victor
  @GetMapping(value="/hiPojo")
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public String hiPojo(@RequestParam final KataModel name) {
    return kataService.response(name);
  }


  //http://localhost:8080/paramsPojoString
  //"{\"name\":\"victor\"}"
  @PostMapping(value="/paramsPojoString", produces =   MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public String paramsPojoString() {
    return "{\"name\":\"victor\"}";
  }

  //http://localhost:8080/hiPojo
  //{\"name\":\"victor\"}
  @PostMapping(value="/paramsPojo", produces =  MediaType.APPLICATION_JSON_VALUE )
  @ResponseStatus(HttpStatus.CREATED)
  public @ResponseBody KataModel paramsPojo(@RequestBody final KataModel name) {
    return kataService.responseModel(name);
  }


}
