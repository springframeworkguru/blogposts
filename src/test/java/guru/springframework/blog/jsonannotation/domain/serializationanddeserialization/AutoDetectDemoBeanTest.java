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

public class AutoDetectDemoBeanTest {
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
    public void testSerializingWithJsonAutoDetect()
            throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(new AutoDetectDemoBean());
        System.out.println(jsonString);
        assertThat(jsonString, containsString("123"));
        assertThat(jsonString, containsString("James Clark"));
    }

    /*@Test
    public void testDeSerializingWithJsonAutoDetect() throws IOException {
        String jsonString = "{\"personId\": 231, \"name\": \"Mary Parker\"}";
        ObjectMapper mapper = new ObjectMapper();
        AutoDetectDemoBean bean = objectMapper.readValue(jsonString, AutoDetectDemoBean.class);
        System.out.println(bean);
        assertThat(bean.getName(), is(equalTo("Mary Parker")));
        assertThat(bean.getPersonId(), is(equalTo(231L)));
    }*/
}
