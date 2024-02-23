package com.exam.sbb.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

  @GetMapping("/saveSession/{name}/{value}")
  @ResponseBody
  public  String saveSession(@PathVariable String name, @PathVariable String value, HttpServletRequest req){
    HttpSession session = req.getSession();
    session.setAttribute(name, value);
    return "세선변수 %s의 값이 %s로 설정되었습니다".formatted(name, value);
  }

  @GetMapping("/getSession/{name}")
  @ResponseBody
  public  String getSession(@PathVariable String name, HttpSession session){
    String value = (String) session.getAttribute(name);

    return "세선변수 %s의 값은 %s입니다".formatted(name, value);
  }

}
