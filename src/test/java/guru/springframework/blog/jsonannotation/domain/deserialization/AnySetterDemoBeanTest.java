package guru.springframework.blog.jsonannotation.domain.deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AnySetterDemoBeanTest {
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
    public void testDeSerializingWithJsonSetter() throws IOException {
        String jsonString = "{\"personId\": 231, \"personName\": \"Mary Parker\", \"emailId\": \"mary@gmail.com\", \"gender\": \"female\"}";
        ObjectMapper mapper = new ObjectMapper();
        AnySetterDemoBean bean = objectMapper.readValue(jsonString, AnySetterDemoBean.class);
        System.out.println(bean);
        assertThat(bean.personName, is(equalTo("Mary Parker")));
        assertThat(bean.personId, is(equalTo(231L)));
        //assertEquals("female", bean.getProperties().get("gender"));
    }
}
