package guru.springframework.blog.jsonannotation.domain.serialization;

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

public class IncludeDemoBeanTest {
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
    public void testSerializingWithJsonInclude() throws JsonProcessingException{
        String jsonString = objectMapper.writeValueAsString(new IncludeDemoBean());
        System.out.println(jsonString);
        assertThat(jsonString, containsString("123"));
        assertThat(jsonString, not(containsString("name")));
    }
}
