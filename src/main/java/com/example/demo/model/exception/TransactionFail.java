package com.example.demo.model.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class TransactionFail extends RuntimeException{
    public TransactionFail(String userID,String message){
        super(String.format("Transaction failed!!! Message: %s",message));
    }
}