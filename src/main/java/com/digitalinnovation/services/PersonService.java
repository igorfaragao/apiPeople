package com.digitalinnovation.services;

import com.digitalinnovation.dto.MessageResponseDTO;
import com.digitalinnovation.dto.request.PersonDTO;
import com.digitalinnovation.entity.Person;
import com.digitalinnovation.exception.PersonNotFoundException;
import com.digitalinnovation.mapper.PersonMapper;
import com.digitalinnovation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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


    public List<PersonDTO> listAll() {

        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());

    }
    public Person verifyIfExist(Long id) throws PersonNotFoundException{
        return personRepository.findById(id)
                .orElseThrow(()-> new PersonNotFoundException(id));

    }
    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExist(id);

        return personMapper.toDTO(person);
    }
    public void delete(Long id) throws PersonNotFoundException {
       verifyIfExist(id);

        personRepository.deleteById(id);

    }

}
