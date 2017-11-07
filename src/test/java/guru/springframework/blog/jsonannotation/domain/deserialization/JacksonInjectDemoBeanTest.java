package guru.springframework.blog.jsonannotation.domain.deserialization;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class JacksonInjectDemoBeanTest {
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
    public void testDeSerializingWithJacksonInject() throws IOException {
        String jsonString = "{\"name\": \"Mary Parker\"}";
        InjectableValues injectableValues = new InjectableValues.Std()
                .addValue(long.class, 231L);
        JacksonInjectDemoBean bean = new ObjectMapper().reader(injectableValues)
                .forType(JacksonInjectDemoBean.class).readValue(jsonString);
        System.out.println(bean);
        assertThat(bean.name, is(equalTo("Mary Parker")));
        assertThat(bean.personId, is(equalTo(231L)));
    }
}
