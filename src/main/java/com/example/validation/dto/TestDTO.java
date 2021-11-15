package com.example.validation.dto;

import com.example.validation.constant.PatternConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/**
 * @author Murphy
 * @date 2021/9/26 10:11
 */
@Data
public class TestDTO {

    @NotNull
    Long id;
    @NotEmpty(message = "姓名不能为空")
    @Length(min=1,max=8)
    String name;
    @Future
    Date date;
    @Pattern(regexp = PatternConstant.REGEXP_CARDNO,message = "身份证格式不正确")
    String cardno;
    @Pattern(regexp = PatternConstant.REGEXP_ZIP)
    String zip;
    @Email
    String email;
    @Pattern(regexp = PatternConstant.REGEXP_PHONE)
    String phone;
    @Size(max=10, min=5)
    String size;
    @Max(20)
    Integer max;

    @Valid
    List<UserDTO> userDTOS;
}
