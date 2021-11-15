package com.example.validation.controller;

import com.example.validation.dto.TestDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author Murphy
 * @date 2021/9/22 15:56
 */
@Validated
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/testParam")
    public TestDTO test(@NotNull Long Id, @Max(20) Integer max){
        TestDTO testDTO = new TestDTO();
        testDTO.setId(Id);
        testDTO.setMax(max);
        return testDTO;
    }


    @PostMapping("/testDTO")
    public TestDTO dtoTest(@Validated @RequestBody TestDTO testDTO){
        return testDTO;
    }
}
