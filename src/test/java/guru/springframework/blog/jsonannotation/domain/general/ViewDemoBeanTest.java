package guru.springframework.blog.jsonannotation.domain.general;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.blog.jsonannotation.domain.serializationanddeserialization.IgnoreDemoBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ViewDemoBeanTest {
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
    public void testSerializingWithJsonView()
            throws JsonProcessingException {
        String jsonString = objectMapper.writerWithView(Views.Public.class)
                .writeValueAsString(new ViewDemoBean());
        String jsonStringInternal = objectMapper.writerWithView(Views.Internal.class)
                .writeValueAsString(new ViewDemoBean());
        System.out.println(jsonString);
        System.out.println(jsonStringInternal);
        assertThat(jsonString, containsString("James Clark"));
        assertThat(jsonString, not(containsString("gender")));
        assertThat(jsonStringInternal, containsString("gender"));
    }

    /*@Test
    public void testDeSerializingWithJsonView() throws IOException {
        String jsonString = "{\"personId\": 231, \"name\": \"Mary Parker\", \"gender\": \"male\"}";
        ObjectMapper mapper = new ObjectMapper();
        ViewDemoBean bean = objectMapper.readerWithView(Views.Public.class)
                .forType(ViewDemoBean.class).readValue(jsonString);
        System.out.println(bean);
        ViewDemoBean beanInternal = objectMapper.readerWithView(Views.Internal.class)
                .forType(ViewDemoBean.class).readValue(jsonString);
        System.out.println(beanInternal);
        assertThat(bean.name, is(equalTo("Mary Parker")));
        assertThat(bean.gender, is(not(equalTo("male"))));
        assertThat(beanInternal.gender, is(equalTo("male")));
    }*/
}
