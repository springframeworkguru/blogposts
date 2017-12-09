package guru.springframework.blog.service;


import guru.springframework.blog.jsonprettyprinting.domain.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    @Override
    public Person processPerson(Person person) {
        /*Code to process person ingormation goes here*/
        System.out.println(person);
        return person;

    }
}
