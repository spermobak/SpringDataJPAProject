package com.bismus.SpringDataJPAProject.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PetByNameNotFoundException extends RuntimeException {
    private final String petName;

    @Override
    public String getMessage() {
        return "Pet with name = " + petName + " not found";
    }
}
