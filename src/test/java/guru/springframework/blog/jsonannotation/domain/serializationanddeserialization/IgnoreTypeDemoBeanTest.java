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

public class IgnoreTypeDemoBeanTest {
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
    public void testSerializingWithJsonIgnoreType()
            throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(new IgnoreTypeDemoBean());
        System.out.println(jsonString);
        assertThat(jsonString, containsString("James Clark"));
        assertThat(jsonString, not(containsString("doorNumber")));
    }

    @Test
    public void testDeSerializingWithJsonIgnoreType() throws IOException {
        String jsonString = "{\"personId\": 123,\"name\": \"Mary Parker\",\"address\": {\"doorNumber\": \"123\",\"streetName\": \"Phase 1\",\"pincode\": \"123456\",\"city\": \"New York\"}}";
        ObjectMapper mapper = new ObjectMapper();
        IgnoreTypeDemoBean bean = objectMapper.readValue(jsonString, IgnoreTypeDemoBean.class);
        System.out.println(bean);
        assertThat(bean.name, is(equalTo("Mary Parker")));
        assertThat(bean.address.doorNumber, is(not(equalTo("123"))));
    }
}
