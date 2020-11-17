package es.alfatecsistemas.sina.application.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;

@Service
@Scope(value="prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class MockMvcPrototype {

  @Autowired
  private MockMvc mockMvc;

  public MockMvc get() { return mockMvc;}

}
