package test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParameterTest {

  @GetMapping("/request_parameter")
  public String test1(@RequestParam String v1, @RequestParam String v2, @RequestParam String v3) {
    return v1 + v2 + v3;
  }

  @PostMapping("/request_parameter")
  public String test2(@RequestBody User u1, @RequestParam String v2, @RequestParam String v3) {
    return v2 + v3 + u1.getId() + u1.getName();
  }
}
