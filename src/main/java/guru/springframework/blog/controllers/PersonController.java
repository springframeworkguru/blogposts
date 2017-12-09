package guru.springframework.blog.controllers;

import guru.springframework.blog.jsonprettyprinting.domain.Person;
import guru.springframework.blog.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    PersonService personService;
    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping("person")
    public ResponseEntity process(Person person) {
        Person processedPerson = this.personService.processPerson(person);
        return ResponseEntity.ok(processedPerson);
    }
}
