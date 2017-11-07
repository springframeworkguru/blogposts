package guru.springframework.blog.jsonannotation.domain.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class GetterDemoBeanTest {
    private ObjectMapper objectMapper;
    @Before
    public void setUp() throws Exception{
        objectMapper = new ObjectMapper();
    }
    @After
    public void tearDown() throws Exception{
        objectMapper = null;
    }
    @Test
    public void testSerializingWithJsonGetter() throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(new GetterDemoBean());
        System.out.println(jsonString);
        assertThat(jsonString, containsString("person-id"));
        assertThat(jsonString, containsString("person-name"));
    }
}
