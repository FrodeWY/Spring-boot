package com.imooc.web.controller;


import com.imooc.web.domain.User;
import java.util.Properties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

  @PostMapping(value = "/echo/user", consumes = "application/json;charset=UTF-8", produces = "application/json")
  public User user(@RequestBody User user) {
    return user;

  }

  @PostMapping(value = "/echo/properties", consumes = "text/properties;charset=UTF-8", produces = "text/properties")
  public Properties properties(@RequestBody Properties properties) {

    return properties;

  }

  @PostMapping(value = "/echo/properties2", consumes = "text/properties;charset=UTF-8", produces = "text/properties")
  public Properties properties2( Properties properties) {

    return properties;

  }
}
