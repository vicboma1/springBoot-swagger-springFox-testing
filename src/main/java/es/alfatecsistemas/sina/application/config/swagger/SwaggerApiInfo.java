package es.alfatecsistemas.sina.application.config.swagger;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

import java.util.Collections;

public class SwaggerApiInfo {

  public static ApiInfo apiInfo() {
    return new ApiInfo(
        "Swagger & SpringFox UI",
        "Description of API.",
        "API v.0.0.1",
        "Terms of service",
        new Contact("vicboma1", "https://github.com/vicboma1", "ho@li.com"),
        "MIT License",
        "https://es.wikipedia.org/wiki/Licencia_MIT",
        Collections.emptyList());
  }
}
