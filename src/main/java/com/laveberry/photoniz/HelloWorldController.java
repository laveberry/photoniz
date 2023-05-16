package com.laveberry.photoniz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//프론트 연동 테스트 위한 컨트롤러
@RestController
public class HelloWorldController {

    @GetMapping("/api/hello")
    public String test(){
        return "Hello, world!";
    }

}
