package com.cetpa.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cetpa.exception.RecordNotFoundException;

@RestControllerAdvice
public class VlidationAndExceptionHandler extends ResponseEntityExceptionHandler
{
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request)
	{
		BindingResult br=ex.getBindingResult();
		List<ObjectError> errors=br.getAllErrors();
		List<String> details=new ArrayList<>();
		for(ObjectError error:errors)
		{
			details.add(error.getDefaultMessage());
		}
		ErrorResponse error=new ErrorResponse("Validation failed",details);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex)
	{
		List<String> details=new ArrayList<>();
		details.add(ex.getMessage());
		ErrorResponse error=new ErrorResponse("Record not found",details);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
