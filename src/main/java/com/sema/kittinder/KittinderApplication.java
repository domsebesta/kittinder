package com.sema.kittinder;

import com.sema.kittinder.configs.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication()
public class KittinderApplication {

  public static void main(String[] args) {
    SpringApplication.run(KittinderApplication.class, args);
  }

}
