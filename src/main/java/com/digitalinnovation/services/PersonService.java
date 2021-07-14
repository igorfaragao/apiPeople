package com.digitalinnovation.services;

import com.digitalinnovation.dto.MessageResponseDTO;
import com.digitalinnovation.entity.Person;
import com.digitalinnovation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;

    }


    public MessageResponseDTO createPerson(Person person){

        Person savedPerson = personRepository.save(person);

        return MessageResponseDTO
                .builder()
                .message("Created person Whit ID " + savedPerson.getId())
                .build();

    }




}
