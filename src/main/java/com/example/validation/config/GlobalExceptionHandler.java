package com.example.validation.config;

import com.example.validation.common.AjaxJson;
import com.example.validation.common.AjaxUtil;
import com.example.validation.constant.PatternConstant;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Murphy
 * @date 2021/9/26 10:35
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = ConstraintViolationException.class)
    public AjaxJson handle1(ConstraintViolationException ex) throws Exception{
        StringBuilder msg = new StringBuilder();
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        List<String> paramError = new ArrayList<>();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            msg = new StringBuilder();
            PathImpl pathImpl = (PathImpl) constraintViolation.getPropertyPath();
            String messageTemplate = constraintViolation.getMessageTemplate();
            String paramName = pathImpl.getLeafNode().getName();
            String defaultmessage = constraintViolation.getMessage();
            String message = defaultmessage;
            /*如何没有定义message提示则统一返回数据校验失败提示*/
            if (!message.equals(messageTemplate)){
                /*判断是否是通过正则验证*/
                int isPattern = messageTemplate.indexOf("Pattern");
                if (isPattern>-1){
                    defaultmessage = defaultmessage.substring(defaultmessage.indexOf("\"")+1,defaultmessage.length());
                    defaultmessage = defaultmessage.substring(0,defaultmessage.indexOf("\""));
                    if (PatternConstant.EGEXP_MAP.get(defaultmessage)!=null){
                        message = PatternConstant.EGEXP_MAP.get(defaultmessage);
                    }
                }
            }
            msg.append("参数[").append(paramName).append("]校验失败：").append(message);
            paramError.add(msg.toString());
        }
        logger.error(msg.toString(),ex);
        return AjaxUtil.paramError("数据校验失败",paramError);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public AjaxJson handle2(MethodArgumentNotValidException ex) throws Exception{
        StringBuilder msg = new StringBuilder();
        BindingResult bindingResult = ex.getBindingResult();
        if(bindingResult!=null){
            if(bindingResult.hasErrors()){
                List<FieldError> fieldErrors = bindingResult.getFieldErrors();
                List<String> paramError = new ArrayList<>();
                for (FieldError fieldError:fieldErrors){
                    msg = new StringBuilder();
                    // 通过反射获取violation的值从而获取messageTemplate
                    Field violationField = fieldError.getClass().getDeclaredField("violation");
                    //设置对象的访问权限，保证对private的属性的访问
                    violationField.setAccessible(true);
                    Field messageTemplateField = violationField.get(fieldError).getClass().getDeclaredField("messageTemplate");
                    messageTemplateField.setAccessible(true);
                    String messageTemplate = (String) messageTemplateField.get(violationField.get(fieldError));
                    String paramName = fieldError.getField();
                    String defaultmessage = fieldError.getDefaultMessage();
                    String message = defaultmessage;
                    /*如何没有定义message提示则统一返回数据校验失败提示*/
                    if (!message.equals(messageTemplate)){
                        /*判断是否是通过正则验证*/
                        int isPattern = messageTemplate.indexOf("Pattern");
                        if (isPattern>-1){
                            defaultmessage = defaultmessage.substring(defaultmessage.indexOf("\"")+1,defaultmessage.length());
                            defaultmessage = defaultmessage.substring(0,defaultmessage.indexOf("\""));
                            if (PatternConstant.EGEXP_MAP.get(defaultmessage)!=null){
                                message = PatternConstant.EGEXP_MAP.get(defaultmessage);
                            }
                        }
                    }
                    msg.append("参数[").append(paramName).append("]校验失败：").append(message);
                    paramError.add(msg.toString());
                }
                logger.error(ex.getMessage(),ex);
                return AjaxUtil.paramError("数据校验失败",paramError);
            }else {
                logger.error(ex.getMessage(),ex);
                return AjaxUtil.error(ex.getMessage());
            }
        }else {
            logger.error(ex.getMessage(),ex);
            return AjaxUtil.error(ex.getMessage());
        }
    }

//    @ExceptionHandler(value = Exception.class)
//    public AjaxJson handle1(Exception ex){
//        logger.error(ex.getMessage(),ex);
//        return AjaxUtil.error(ex.getMessage());
//    }
}
