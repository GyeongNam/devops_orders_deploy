package com.encore.OrderService.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<CommonResponse> home(){
        return CommonResponse.responseMassage(HttpStatus.OK, "home 확인완료");
    }
}
