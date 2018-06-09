package com.sunyard.myproject.exceptionhandler;

import com.sunyard.myproject.exception.TopicNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Administrator on 2018/4/21.
 */
@ControllerAdvice
public class PCExceptionHandler {
    @ExceptionHandler(TopicNotFoundException.class)
    public String topicNotFoundHandler(){
        return "error/topicNotFound";
    }
}
