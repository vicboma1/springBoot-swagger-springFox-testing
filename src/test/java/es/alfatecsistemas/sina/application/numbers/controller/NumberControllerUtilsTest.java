package es.alfatecsistemas.sina.application.numbers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: vicboma1
 */
@Service
public class NumberControllerUtilsTest {

  @Autowired
  private final MockMvc mockMvc;

  public NumberControllerUtilsTest(final MockMvc mockMvc){
    this.mockMvc = mockMvc;
  }

  public void size(final Integer size) throws Exception {
    final String url = "/size";
    final String expectedContent = "{\"value\":"+size+"}";
    _get_(url,expectedContent);
  }

  public void clear(final Boolean result) throws Exception {
    final String url = "/clear";
    final String expectedContent = "{\"value\":"+result+"}";
   _get_(url,expectedContent);
  }

  public void _get_(final String urlSize, final String result) throws Exception {
    mockMvc.perform( MockMvcRequestBuilders
        .get(urlSize)
        .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(result));
  }

  public void addAll(final String inputs, final Boolean result) throws Exception {
    final String urlPost = "/addAll";

    mockMvc.perform( MockMvcRequestBuilders
        .post(urlPost)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON)
        .content(inputs))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("{\"value\":"+result+"}"));
  }

  public void createLazy(final Integer res) throws Exception {
    final String urlTemplate = "/createLazy";

    mockMvc.perform( MockMvcRequestBuilders
        .put(urlTemplate)
        .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andDo(print())
        .andExpect(status().isCreated())
        .andExpect(content().string("{\"value\":"+res+"}"));

  }

  public void add(final Integer input, final Boolean result) throws Exception {
    final String urlPost = "/add";

    mockMvc.perform( MockMvcRequestBuilders
        .post(urlPost)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON)
        .content(String.valueOf(input)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("{\"value\":"+result+"}"));
  }

  public void delete(final Integer value, final Boolean res) throws Exception {
    final String urlSize = "/delete/{id}";
    final String expectedContent = "{\"value\":"+res+"}";

    mockMvc.perform( MockMvcRequestBuilders
        .delete(urlSize,value))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(expectedContent));
  }
}
