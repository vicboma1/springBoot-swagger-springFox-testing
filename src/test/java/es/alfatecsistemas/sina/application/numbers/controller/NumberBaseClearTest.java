package es.alfatecsistemas.sina.application.numbers.controller;

import es.alfatecsistemas.sina.application.test.BaseTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: vicboma1
 */
@RunWith(SpringRunner.class)
@WebMvcTest(NumberController.class)
public class NumberBaseClearTest extends BaseTest {

  @Test
  public void size() throws Exception {
    test.size(0);
  }

  @Test
  public void sizeOne() throws Exception {
    test.size(0);
    test.add(1,true);
    test.size(1);
  }

}
