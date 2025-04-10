package com.example.demo.exception;

import com.example.demo.dto.ErrorDtoRp;
import com.example.demo.dto.ParamsErrorDto;
import com.example.demo.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({NoResourceFoundException.class, HttpMessageNotReadableException.class,
            MethodArgumentNotValidException.class})
    protected ResponseEntity<ErrorDtoRp> handleErrorException(Exception ex) {
        if (ex instanceof MethodArgumentNotValidException exTipo) return ResponseEntity.badRequest().body(paramErrorHandler(exTipo));
        if (ex instanceof HttpMessageNotReadableException) return ResponseEntity.badRequest().body(setResponseDto());
        if (ex instanceof NoResourceFoundException) return ResponseEntity.badRequest().body(setResponseDto());
        else return ResponseEntity.internalServerError().build();
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatchException() {
        return ResponseEntity.badRequest().build();
    }

    private ErrorDtoRp setResponseDto() {
        ErrorDtoRp errorDtoRp = new ErrorDtoRp();
        errorDtoRp.setCodigo(1);
        errorDtoRp.setStatus("NOK");
        return errorDtoRp;
    }

    private ErrorDtoRp paramErrorHandler(MethodArgumentNotValidException ex) {
        List<ParamsErrorDto> listParamError = new ArrayList<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error ->
                        listParamError.add(new ParamsErrorDto(error.getField(), error.getDefaultMessage())));
        ErrorDtoRp errorDtoRp = setResponseDto();
        errorDtoRp.setDetalle(listParamError);
        return errorDtoRp;
    }
}
