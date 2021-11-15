package com.example.validation.dto;

import com.example.validation.constant.PatternConstant;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author Murphy
 * @date 2021/9/28 13:45
 */
@Data
public class UserDTO {

    @NotNull
    Long userid;

    @NotNull
    @Pattern(regexp = PatternConstant.REGEXP_ENG_NUM_OR_)
    String username;

    @NotNull
    @Pattern(regexp = PatternConstant.REGEXP_6_17_PASSWORD_ENG_NUM_OR_)
    String password;

    @Valid
    List<TestDTO> testDTOS;
}
