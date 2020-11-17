package es.alfatecsistemas.sina.application.numbers.controller;

import es.alfatecsistemas.sina.application.test.BaseTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @Author: vicboma1
 */
@RunWith(SpringRunner.class)
@WebMvcTest(NumberController.class)
public class NumberBaseDeleteTest extends BaseTest {

  @Test
  public void delete() throws Exception {
    test.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9).toString(),true);
    test.size(9);
    test.delete(9,true);
    test.size(8);
    test.addAll(Arrays.asList(1,2,3,10,11).toString(),true);
    test.size(10);
    test.delete(6,true);
    test.delete(7,true);
    test.delete(7,false);
    test.size(8);
  }



}
