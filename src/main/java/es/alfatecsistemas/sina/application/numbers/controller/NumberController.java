package es.alfatecsistemas.sina.application.numbers.controller;

import es.alfatecsistemas.sina.application.numbers.model.NumberModel;
import es.alfatecsistemas.sina.application.numbers.repository.NumberRepository;
import es.alfatecsistemas.sina.application.numbers.service.NumberService;

import org.junit.jupiter.api.MethodOrderer.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;

import javax.annotation.PostConstruct;

/**
 * @Author: vicboma1
 */
@Controller
public class NumberController {

  @Autowired
  private NumberRepository numberRepository;

  @Autowired
  private NumberService numberService;

  public NumberController(){ }

  @PostConstruct
  public void PostConstructor() {
  }

   //http://localhost:8080/size
  @GetMapping(value="/size", produces =  MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public NumberModel size() {
    final Integer size = numberRepository.size();
    return numberService.toMessage(size);
  }

  //http://localhost:8080/clear
  @GetMapping(value="/clear", produces =  MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public NumberModel clear() {
    final Boolean res = numberRepository.clear();
    return numberService.toMessage(res);
  }

  //http://localhost:8080/add
  //"{\"value\":\"1\"}"
  @PostMapping(value="/add", produces =   MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public NumberModel add(@RequestBody final Integer input) {
    final Boolean res = numberRepository.add(input);
    return numberService.toMessage(res);
  }

  //http://localhost:8080/addAll
  //"{\"value\":\"[1,2,3,4,5,6]\"}"
  @PostMapping(value="/addAll", produces =   MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public NumberModel addAll(@RequestBody final Set<Integer> set){
    final Boolean res = numberRepository.addAll(set);
    return numberService.toMessage(res);
  }

  //http://localhost:8080/createLazy
  @PutMapping(value="/createLazy", produces =  MediaType.APPLICATION_JSON_VALUE )
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public NumberModel createSetLazy() {

    return numberService.toMessage(Integer.valueOf(100));
  }

  //http://localhost:8080//delete/{id}
  @DeleteMapping(value="/delete/{id}", produces =  MediaType.APPLICATION_JSON_VALUE )
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public NumberModel delete(@PathVariable final Integer id) {
    final Boolean value = numberRepository.delete(id);
    return numberService.toMessage(value);
  }


}
