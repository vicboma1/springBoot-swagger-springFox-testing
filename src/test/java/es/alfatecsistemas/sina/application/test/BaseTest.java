package es.alfatecsistemas.sina.application.test;

import es.alfatecsistemas.sina.application.numbers.controller.NumberControllerUtilsTest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.function.Supplier;

/**
 * @Author: vicboma1
 */

@ComponentScan("es.alfatecsistemas.sina")
public class BaseTest {

  @Autowired
  protected  MockMvcPrototype mockMvcPrototype;

  @Autowired
  protected NumberControllerUtilsTest test;

  public BaseTest() {}

  @Before
  public void setUp() throws Exception {
    test.clear(true);
  }


}
