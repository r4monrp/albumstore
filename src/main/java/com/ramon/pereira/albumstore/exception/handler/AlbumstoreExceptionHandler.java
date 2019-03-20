package com.ramon.pereira.albumstore.exception.handler;

import com.ramon.pereira.albumstore.exception.DiscNotFoundException;
import com.ramon.pereira.albumstore.exception.SaleNotFoundException;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Order(0)
public class AlbumstoreExceptionHandler {

  @ResponseBody
  @ExceptionHandler(DiscNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorMessage exceptionHandler(final DiscNotFoundException ex) {
    return ErrorMessage.builder()
        .developerMessage("No records were found for your search")
        .userMessage("No records were found for your search")
        .errorCode(1).build();
  }

  @ResponseBody
  @ExceptionHandler(SaleNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorMessage exceptionHandler(final SaleNotFoundException ex) {
    return ErrorMessage.builder()
        .developerMessage("No records were found for your search")
        .userMessage("No records were found for your search")
        .errorCode(1).build();
  }
}