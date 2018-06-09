package com.sunyard.myproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 2018/4/21.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Topic Not Found")
public class TopicNotFoundException extends RuntimeException {
}
