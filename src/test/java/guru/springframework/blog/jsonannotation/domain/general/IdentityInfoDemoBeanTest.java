package guru.springframework.blog.jsonannotation.domain.general;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class IdentityInfoDemoBeanTest {
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
    public void testSerializingWithJsonIdentityInfo()
            throws JsonProcessingException {
        IdentityInfoManagerDemoBean demoBean = new IdentityInfoManagerDemoBean(123L, "Mary Parker");
        IdentityInfoEmployeeDemoBean bean = new IdentityInfoEmployeeDemoBean(231L, "John Thomas", demoBean);
        demoBean.addEmployees(bean);
        String jsonString = objectMapper.writeValueAsString(bean);
        System.out.println(jsonString);
        assertThat(jsonString, containsString("John Thomas"));
        assertThat(jsonString, containsString("231"));
        assertThat(jsonString, containsString("employees"));
    }
}
