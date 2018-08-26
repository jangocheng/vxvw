package com.snax.vxvw.vxvwcore.config;

import com.snax.vxvw.vxvwcore.util.ResponseUtil;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

/**
 * 配置全局异常处理(能够走Controller的异常，404和500除外)
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public Object badArgumentHandler(IllegalArgumentException e){
        e.printStackTrace();
        return ResponseUtil.badArgumentValue();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Object badArgumentHandler(MethodArgumentTypeMismatchException e){
        e.printStackTrace();
        return ResponseUtil.badArgumentValue();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Object badArgumentHandler(MissingServletRequestParameterException e){
        e.printStackTrace();
        return ResponseUtil.badArgumentValue();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object badArgumentHandler(HttpMessageNotReadableException e){
        e.printStackTrace();
        return ResponseUtil.badArgumentValue();
    }

    @ExceptionHandler(ValidationException.class)
    public Object badArgumentHandler(ValidationException e){
        e.printStackTrace();
        if (e instanceof ConstraintViolationException){
            ConstraintViolationException exs=(ConstraintViolationException) e;
            Set<ConstraintViolation<?>> violations=exs.getConstraintViolations();
            for (ConstraintViolation<?> item:violations){
                String message=((PathImpl)item.getPropertyPath()).getLeafNode().getName()+item.getMessage();
                return ResponseUtil.fail(402,message);
            }
        }
        return ResponseUtil.badArgumentValue();
    }

    @ExceptionHandler(Exception.class)
    public Object seriousHanlder(Exception e){
        e.printStackTrace();
        return ResponseUtil.serious();
    }
}
