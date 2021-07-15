package com.digitalinnovation.controller;

import com.digitalinnovation.dto.MessageResponseDTO;
import com.digitalinnovation.dto.request.PersonDTO;
import com.digitalinnovation.entity.Person;
import com.digitalinnovation.repository.PersonRepository;
import com.digitalinnovation.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

}
