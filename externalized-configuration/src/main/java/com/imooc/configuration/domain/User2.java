package com.imooc.configuration.domain;


public class User2 {

  private Long id;

  private String name;

  private Integer age;

  private String desc;

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

  public User2() {
  }

  public User2(Long id, String name, String desc, Integer age) {
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + ", desc=" + desc + ", age=" + age + '\'' +
        '}';
  }
}
