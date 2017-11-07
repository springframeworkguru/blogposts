package guru.springframework.blog.jsonannotation.domain.serializationanddeserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class IgnorePropertiesDemoBeanTest {
    private ObjectMapper objectMapper ;
    @Before
    public void setUp() throws Exception{
        objectMapper = new ObjectMapper();
    }
    @After
    public void tearDown() throws Exception{
        objectMapper = null;
    }

    @Test
    public void testSerializingWithJsonIgnoreProperties()
            throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(new IgnorePropertiesDemoBean());
        System.out.println(jsonString);
        assertThat(jsonString, containsString("James Clark"));
        assertThat(jsonString, not(containsString("userId")));
    }

    @Test
    public void testDeSerializingWithJsonIgnoreProperties() throws IOException {
        String jsonString = "{\"userId\": 231, \"name\": \"Mary Parker\", \"gender\": \"male\"}";
        ObjectMapper mapper = new ObjectMapper();
        IgnorePropertiesDemoBean bean = objectMapper.readValue(jsonString, IgnorePropertiesDemoBean.class);
        System.out.println(bean);
        assertThat(bean.name, is(equalTo("Mary Parker")));
        assertThat(bean.userId, is(not(equalTo(231L))));
    }

}