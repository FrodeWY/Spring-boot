package com.imooc.spring.reactive.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Test {

  public static void main(String[] args) {
    List<User> list1 = new ArrayList<>();
    List<User> list2 = new ArrayList<>();
    list1.add(new User(1,"1"));
    list1.add(new User(2,"2"));
    list1.add(new User(3,"99"));

    list2.add(new User(1,"lili"));
    list2.add(new User(2,"didi"));

    List<User> users = list1.stream().map(u ->
          list2.stream()
            .filter(u2 -> u2.getId().equals(u.getId()))
            .findFirst()
            .map(u3 -> {
              u.setName(u3.getName());
              return u;
            })
            .orElse(null))
        .filter(Objects::nonNull)
        .collect(Collectors.toList());

    if (users!=null) {
      for (User user : users) {
        System.out.println("id:"+user.getId()+" name:"+user.getName());
      }
    }
  }

}
