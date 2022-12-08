package com.bismus.SpringDataJPAProject.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PetByIdNotFoundException extends RuntimeException{
    private final int petId;

    @Override
    public String getMessage() {
        return "Pet with id = " + petId + " not found";
    }
}
