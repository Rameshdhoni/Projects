package com.capstone.ams.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	/*
	 * @ExceptionHandler(value = { IllegalArgumentException.class,
	 * IllegalStateException.class }) protected ResponseEntity<Object>
	 * handleConflict(RuntimeException ex, WebRequest request) { List<String>
	 * actualList = new ArrayList<String>();
	 * request.getParameterNames().forEachRemaining(actualList::add);
	 * 
	 * String bodyOfResponse = "AMS - There is problem in accessing  " +
	 * request.getDescription(false) + " parameters:" + actualList.toString();
	 * return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(),
	 * HttpStatus.CONFLICT, request); }
	 */
}