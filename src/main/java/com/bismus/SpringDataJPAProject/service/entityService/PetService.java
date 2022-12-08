package com.bismus.SpringDataJPAProject.service.entityService;


import com.bismus.SpringDataJPAProject.exception.PetByIdNotFoundException;
import com.bismus.SpringDataJPAProject.exception.PetByNameNotFoundException;
import com.bismus.SpringDataJPAProject.exception.PetTableIsEmptyException;
import com.bismus.SpringDataJPAProject.model.Pet;
import com.bismus.SpringDataJPAProject.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public List<Pet> findAll() {
        if (petRepository.findAll().isEmpty()) throw new PetTableIsEmptyException();
        return petRepository.findAll();
    }

    public Pet findById(int id) {
        Optional<Pet> foundedPet = petRepository.findById(id);
        return foundedPet.orElseThrow(()-> new PetByIdNotFoundException(id));
    }

    public List<Pet> findByName(String name) {
        if (petRepository.findByName(name).isEmpty()) throw new PetByNameNotFoundException(name);
        return petRepository.findByName(name);
    }

    @Transactional
    public void addNewPet(Pet pet){
        petRepository.save(pet);
    }

    @Transactional
    public void updatePetParam(int id, Pet updatedPet) {
        updatedPet.setId(id);
        petRepository.save(updatedPet);
    }

    @Transactional
    public void resetOwner(int petId, int personId) {

    }

    @Transactional
    public void deletePet(int id) {
        petRepository.deleteById(id);
    }
}
