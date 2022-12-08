package com.bismus.SpringDataJPAProject.repository;

import com.bismus.SpringDataJPAProject.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository <Person, Integer> {

    List<Person> findByName (String name);
}
