package guru.springframework.blog.jsonannotation.domain.general;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class FormatDemoBeanTest {
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
    public void testSerializingWithJsonFormat()
            throws JsonProcessingException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateAndTime = "26-09-2017 11:00:00";
        Date date = simpleDateFormat.parse(dateAndTime);
        FormatDemoBean fb = new FormatDemoBean();
        fb.setActiveDate(date);
        String jsonString = objectMapper.writeValueAsString(fb);
        System.out.println(jsonString);
        assertThat(jsonString, containsString("James Clark"));
        assertThat(jsonString, containsString("123"));
        assertThat(jsonString, containsString("26-09-2017 11:00:00"));
    }
}
