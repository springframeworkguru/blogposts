package guru.springframework.blog.jsonannotation.domain.deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DeserializeDemoBeanTest {
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
    public void testDeSerializingWithJsonDeserialize() throws IOException {
        String jsonString = "{\"personId\": 231, \"name\": \"Mary Parker\", " +
                "\"activeDate\":\"26-09-2017 11:00:00\"}";
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        ObjectMapper mapper = new ObjectMapper();
        DeserializeDemoBean bean = objectMapper.readValue(jsonString, DeserializeDemoBean.class);
        System.out.println(bean);
        assertThat(bean.name, is(equalTo("Mary Parker")));
        assertThat(bean.personId, is(equalTo(231L)));
        assertEquals("26-09-2017 11:00:00", simpleDateFormat.format(bean.activeDate));
    }
}
