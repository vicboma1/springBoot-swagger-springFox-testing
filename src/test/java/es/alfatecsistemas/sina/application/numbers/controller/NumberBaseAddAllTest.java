package es.alfatecsistemas.sina.application.numbers.controller;

import es.alfatecsistemas.sina.application.test.BaseTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

/**
 * @Author: vicboma1
 */
@RunWith(SpringRunner.class)
@WebMvcTest(NumberController.class)
public class NumberBaseAddAllTest extends BaseTest {

  @Test
  public void addAll() throws Exception {
   test.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9).toString(),true);
   test.size(9);
   test.addAll(Arrays.asList(1,2,3).toString(),false);
   test.size(9);
   test.addAll(Arrays.asList(1,2,3,120).toString(),true);
   test.size(10);
  }

}
