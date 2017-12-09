package guru.springframework.blog.jsonprettyprinting.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PersonTest {
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @After
    public void tearDown() throws Exception {
        objectMapper = null;
    }

    @Test
    public void testJsonPrettyPrintObject() throws JsonProcessingException {
        /*JSON without pretty print*/
        String jsonCompactString = objectMapper.writeValueAsString(new Person());
        System.out.println("JSON without pretty print");
        System.out.println(jsonCompactString);
        assertThat(jsonCompactString, containsString("person-id"));
        assertThat(jsonCompactString, containsString("person-name"));
        /*JSON with pretty print*/
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(new Person());
        System.out.println("JSON with pretty print");
        System.out.println(jsonString);
        assertThat(jsonString, containsString("person-id"));
        assertThat(jsonString, containsString("person-name"));
    }

    @Test
    public void testJsonPrettyPrintString() throws IOException {
        String jsonString = "{\"person-id\": 231, \"person-name\": \"Mary Parker\"}";
        /*JSON output in compact mode:*/
        System.out.println("JSON without mapping to object");
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonString));
        /*Reading into POJO and pretty print*/
        System.out.println("JSON  mapping to POJO with pretty print");
        Person bean = objectMapper
                .readValue(jsonString, Person.class);
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(bean));
        assertThat(bean.personName, is(equalTo("Mary Parker")));
        assertThat(bean.personId, is(equalTo(231L)));
        /*Reading into Object and pretty print*/
        Object object = objectMapper
                .readValue(jsonString, Object.class);
        System.out.println("JSON  mapping to Object with pretty print");
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(object));

    }
}
