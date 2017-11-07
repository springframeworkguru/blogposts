package guru.springframework.blog.jsonannotation.domain.general;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class FilterDemoBeanTest {
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
    public void testSerializingWithJsonFilter()
            throws JsonProcessingException {
        FilterProvider filterProvider = new SimpleFilterProvider().
                addFilter("customFilter",
                        SimpleBeanPropertyFilter.filterOutAllExcept("name"));
        String jsonString = objectMapper.writer(filterProvider).
                writeValueAsString(new FilterDemoBean());
        System.out.println(jsonString);
        assertThat(jsonString, containsString("James Clark"));
        assertThat(jsonString, not(containsString("123")));
    }
    /*@Test
    public void testDeSerializingWithJsonProperty() throws IOException {
        String jsonString = "{\"person-id\": 231, \"name\": \"Mary Parker\"}";
        ObjectMapper mapper = new ObjectMapper();
        PropertyDemoBean bean = objectMapper.readValue(jsonString, PropertyDemoBean.class);
        System.out.println(bean);
        assertThat(bean.name, is(equalTo("Mary Parker")));
        assertThat(bean.personId, is(equalTo(231L)));
    }*/
}
