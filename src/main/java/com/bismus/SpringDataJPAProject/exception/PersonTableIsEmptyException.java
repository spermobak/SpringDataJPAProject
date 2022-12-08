package com.bismus.SpringDataJPAProject.exception;

public class PersonTableIsEmptyException extends RuntimeException{

    @Override
   public String getMessage(){
        return "Table of person is empty.";
    }
}
