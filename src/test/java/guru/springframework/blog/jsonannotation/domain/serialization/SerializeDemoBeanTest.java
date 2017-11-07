package guru.springframework.blog.jsonannotation.domain.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class SerializeDemoBeanTest {
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
    public void testSerializingWithJsonSerialize() throws JsonProcessingException,ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String date = "29-09-2017 10:00:00";
        Date newDate = simpleDateFormat.parse(date);
        SerializeDemoBean bean = new SerializeDemoBean();
        bean.setActiveDate(newDate);
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bean);
        System.out.println(jsonString);
        assertThat(jsonString, containsString("James Clark"));
        assertThat(jsonString, containsString("123"));
        assertThat(jsonString, containsString("29-09-2017 10:00:00"));
    }
}
