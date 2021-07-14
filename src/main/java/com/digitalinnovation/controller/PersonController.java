package com.digitalinnovation.controller;

import com.digitalinnovation.dto.MessageResponseDTO;
import com.digitalinnovation.entity.Person;
import com.digitalinnovation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;

    }

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person){

        Person savedPerson = personRepository.save(person);

          return MessageResponseDTO
                  .builder()
                  .message("Created person Whit ID " + savedPerson.getId())
                  .build();

    }

}
