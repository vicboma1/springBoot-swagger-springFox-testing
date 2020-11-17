# MVC Spring - Testing - Swagger - SpringFox-UI

Proyecto piloto para testear endpoints junto con un frontend

## Tech
*   SpringBootApplication
*   Swagger
*   SpringFox
*   MVC
*   Controller
*   Service
*   Model
*   Repository

## URL -> http://localhost:8080/swagger-ui.html#/ 

<img src="https://github.com/vicboma1/springBoot-swagger-springFox-testing/blob/main/assets/Api.gif" width="800" height="640" />

## Swagger2
```
  /**
   * Busca en todo el package cualquier @Controller publicado
   * @return
   */
  @Bean
  public Docket api(){
    final ApiSelectorBuilder select = new Docket(DocumentationType.SWAGGER_2).select();
    return select
        .apis((Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("es.alfatecsistemas.sina.application"))
        .paths((Predicate<String>) PathSelectors.any())
        .build()
        .apiInfo(SwaggerApiInfo.apiInfo());
  }

```

## Test
 * Kata
 * Numbers (CRUD)

## Test básicos
```
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

```

## Colaboradores para test Numbers

```
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

```
