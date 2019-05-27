package com.imooc.configuration.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("user")//可用用于类上进行属性绑定
@Validated
public class User3 {

  private Long id;

  private String name;

  private Integer age;

  private String desc;

  private City city;

  private static class City {

    private String postCode;
    @NotBlank
    private String name;

    public String getPostCode() {
      return postCode;
    }

    public void setPostCode(String postCode) {
      this.postCode = postCode;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return "City{" +
          "postCode='" + postCode + '\'' +
          ", name='" + name + '\'' +
          '}';
    }
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User3() {
  }

  public User3(Long id, String name, String desc, Integer age) {
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.age = age;
  }

  @Override
  public String toString() {
    return "User3{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", desc='" + desc + '\'' +
        ", city=" + city +
        '}';
  }
}
