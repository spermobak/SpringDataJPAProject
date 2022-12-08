package com.bismus.SpringDataJPAProject.repository;

import com.bismus.SpringDataJPAProject.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository <Pet, Integer> {

    List<Pet> findByName (String name);
}