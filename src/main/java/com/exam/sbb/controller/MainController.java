package com.exam.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
  @RequestMapping("/sbb")
  @ResponseBody
  public String index(){
    return "Hello World";
  }
  @GetMapping("/test")
  @ResponseBody
  public  String showMain(){
    return """
        <h1>안녕하세요</h1>
        <input type='text' placeholder='입력해 주세요' />
        """;
  }

  @GetMapping("/mbti/{name}")
  @ResponseBody
  public  String mbti(@PathVariable String name){
    return switch (name){
      case "jang" -> "INFP";
      case "brian" -> "ENFP";
      default -> "모름";
    };
  }

}
