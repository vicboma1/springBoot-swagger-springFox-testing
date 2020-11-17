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
public class NumberBaseCreateTest extends BaseTest {

  @Test
  public void createLazy() throws Exception {
    test.createLazy(100);
  }


}
