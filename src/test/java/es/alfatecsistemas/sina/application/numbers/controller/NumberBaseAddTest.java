package es.alfatecsistemas.sina.application.numbers.controller;

import es.alfatecsistemas.sina.application.test.BaseTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @Author: vicboma1
 */
@RunWith(SpringRunner.class)
@WebMvcTest(NumberController.class)
public class NumberBaseAddTest extends BaseTest {

  @Test
  public void add() throws Exception {
    test.size(0);
    test.add(10,true);
    test.size(1);
    test.add(11,true);
    test.size(2);
    test.add(10,false);
    test.size(2);
  }

}
