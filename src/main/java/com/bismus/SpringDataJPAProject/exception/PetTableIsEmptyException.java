package com.bismus.SpringDataJPAProject.exception;

public class PetTableIsEmptyException extends RuntimeException {
    @Override
    public String getMessage(){
        return "Table of pet is empty.";
    }
}
