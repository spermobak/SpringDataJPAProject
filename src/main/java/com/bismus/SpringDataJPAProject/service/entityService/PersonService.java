package com.bismus.SpringDataJPAProject.service.entityService;



import com.bismus.SpringDataJPAProject.exception.PersonByIdNotFoundException;
import com.bismus.SpringDataJPAProject.exception.PersonByNameNotFoundException;
import com.bismus.SpringDataJPAProject.exception.PersonTableIsEmptyException;
import com.bismus.SpringDataJPAProject.model.Person;
import com.bismus.SpringDataJPAProject.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAll(){
        if (personRepository.findAll().isEmpty()) throw new PersonTableIsEmptyException();
        return personRepository.findAll();
    }

    public Person findById(int id){
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElseThrow(()->new PersonByIdNotFoundException(id));
    }

    public List<Person> findByName(String name){
        if(personRepository.findByName(name).isEmpty()) throw new PersonByNameNotFoundException(name);
        return personRepository.findByName(name);
    }

    @Transactional
    public void addNewPerson(Person person){
        personRepository.save(person);
    }

    @Transactional
    public void updatePersonParam(int id, Person updatedPerson){
        updatedPerson.setId(id);
        personRepository.save(updatedPerson);
    }

    @Transactional
    public void deletePerson(int id){
        personRepository.deleteById(id);
    }
}
