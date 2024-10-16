package guru.springframework.blog.jsonprettyprinting.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

/**
 * Created by jt, Spring Framework Guru.
 */
public class TestObjectMapper {

    @Test
    public void testGlobal() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Person person = new Person();
        person.setPersonId(1L);
        person.setPersonName("John Doe");

        System.out.println(objectMapper.writeValueAsString(person));
    }
}
