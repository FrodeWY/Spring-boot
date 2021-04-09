package com.imooc.configuration.domain;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class User {

  @Value("${user.id}")//propertySource有加载顺序，system.getProperty()的属性优先于application.properties文件中的属性
  private Long id;
  /*
   propertySource有加载顺序，system.getProperty()的属性优先于application.properties文件中的属性，
   所以这里真实注入的是系统用户名 而不是application.properties中的user.name
   */
  @Value("${user.name}")
  private String name;

  private Integer age;
  //@Value 添加默认值，如果外部化配置有user.desc则使用外部配置的user.desc，否则使用默认值
  @Value(value = "${user.desc:Hello world}")
  private String desc;
  @Value(value = "${user.roles:role1,role2}")
  private List<String> roles;

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
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

  public User() {
  }

  public User(Long id, String name, String desc, Integer age) {
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", desc='" + desc + '\'' +
            ", roles=" + roles +
            '}';
  }
}
