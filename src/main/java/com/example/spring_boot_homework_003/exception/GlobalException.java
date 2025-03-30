//package com.example.spring_boot_homework_003.exception;
//
//import org.apache.ibatis.javassist.NotFoundException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//
//@RestControllerAdvice
//public class GlobalException {
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<?> handleNotFoundException(NotFoundException e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//    }
//}
