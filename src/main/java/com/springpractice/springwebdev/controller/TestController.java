package com.springpractice.springwebdev.controller;

import com.springpractice.springwebdev.dto.ResponseDTO;
import com.springpractice.springwebdev.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String testController(){
        return "hello";
    }

    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO){
        return testRequestBodyDTO.getId() + " : " + testRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody(){
        List<String> list = new ArrayList();

        list.add("Hello World");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

        return response;
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity(){
        List<String> list = new ArrayList();
        list.add("Hi Hi Nice!!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

        // http 400 설정
        return ResponseEntity.ok().body(response);
    }

}
