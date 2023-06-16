package com.victormanduca.eventbooking.presentention.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException exception) {
		List<String> errors = new ArrayList<>();

		exception.getBindingResult()
			.getFieldErrors()
			.forEach(error -> errors.add(error.getDefaultMessage()));

		return ResponseEntity.badRequest().body(errors);
	}
}