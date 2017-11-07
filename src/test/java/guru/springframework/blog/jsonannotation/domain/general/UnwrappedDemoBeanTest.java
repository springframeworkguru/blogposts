package guru.springframework.blog.jsonannotation.domain.general;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class UnwrappedDemoBeanTest {
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
    public void testSerializingWithJsonUnwrapped()
            throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(new UnwrappedDemoBean());
        System.out.println(jsonString);
        assertThat(jsonString, containsString("James Clark"));
        assertThat(jsonString, not(containsString("address")));
    }
}
