package es.alfatecsistemas.sina.application.kata.controller;

import es.alfatecsistemas.sina.application.test.BaseTest;
import es.alfatecsistemas.sina.application.kata.service.KataService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: vicboma1
 */
@RunWith(SpringRunner.class)
@WebMvcTest(KataController.class)
public class KataBaseTest extends BaseTest {

  @Before
  public void setUp()  {
  }

  @After
  public void tearDown() throws Exception {
  }

  //http://localhost:8080/hello
  @Test
  public void getHello() throws Exception {
    final String urlTemplate = "/hello";

    mockMvcPrototype.get().perform( MockMvcRequestBuilders
        .get(urlTemplate)
        .contentType(MediaType.TEXT_PLAIN_VALUE))
        .andDo(print())
        .andExpect(status().isOk());
  }

  //http://localhost:8080/hi?name=victor
  @Test
  public void getHiString() throws Exception {
    final String PARAM = "victor";
    final String expected = KataService.PREFIX+" "+PARAM;;
    final String urlTemplate = "/hi?name=" + PARAM;

    mockMvcPrototype.get().perform( MockMvcRequestBuilders
        .get(urlTemplate)
        .contentType(MediaType.TEXT_PLAIN_VALUE))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(expected));
  }

  //http://localhost:8080/hiPojo?name=victor
  @Test
  public void getHiPojo() throws Exception {
    final String PARAM = "victor";
    final String expected = KataService.PREFIX+" "+PARAM;;
    final String urlTemplate = "/hiPojo?name=" + PARAM;

    mockMvcPrototype.get().perform( MockMvcRequestBuilders
        .get(urlTemplate)
        .contentType(MediaType.TEXT_PLAIN_VALUE))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(expected));

  }

  //http://localhost:8080/paramsPojoString
  //"{\"name\":\"victor\"}"
  @Test
  public void paramsPojoString() throws Exception {
    final String expected = "{\"name\":\"victor\"}";
    final String urlTemplate = "/paramsPojoString";

    mockMvcPrototype.get().perform( MockMvcRequestBuilders
        .post(urlTemplate)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(expected));
  }

  //http://localhost:8080/paramsPojoString
  //"{\"name\":\"victor\"}"
  @Test
  public void paramsPojoJSON() throws Exception {
    final String input = "{\"name\":\"victor\"}";
    final String expectedName = "Hi victor";
    final String expected = "{\"name\":\"" + expectedName + "\"}";
    final String urlTemplate = "/paramsPojo";

    mockMvcPrototype.get().perform( MockMvcRequestBuilders
        .post(urlTemplate)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON)
        .content(input))
        .andDo(print())
        .andExpect(status().isCreated())
        .andExpect(content().string(expected))
        .andExpect(jsonPath("$.name").value(expectedName));
  }
}
