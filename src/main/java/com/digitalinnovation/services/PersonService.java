package com.digitalinnovation.services;

import com.digitalinnovation.dto.MessageResponseDTO;
import com.digitalinnovation.dto.request.PersonDTO;
import com.digitalinnovation.entity.Person;
import com.digitalinnovation.mapper.PersonMapper;
import com.digitalinnovation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;

    }


    public MessageResponseDTO createPerson(PersonDTO personDTO){

    Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Created person Whit ID " + savedPerson.getId())
                .build();

    }




}
