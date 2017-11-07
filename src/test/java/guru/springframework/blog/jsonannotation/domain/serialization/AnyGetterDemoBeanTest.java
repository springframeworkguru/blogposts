package guru.springframework.blog.jsonannotation.domain.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class AnyGetterDemoBeanTest {
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
    public void testSerializingWithJsonAnyGetter() throws JsonProcessingException {
        AnyGetterDemoBean bean = new AnyGetterDemoBean();
        Map<String, String > stringMap = bean.getProperties();
        stringMap.put("emailId","james@gmail.com");
        stringMap.put("gender","male");
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bean);
        System.out.println(jsonString);
        assertThat(jsonString, containsString("emailId"));
        assertThat(jsonString, containsString("gender"));
    }
}
