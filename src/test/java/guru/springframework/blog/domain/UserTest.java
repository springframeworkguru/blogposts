package guru.springframework.blog.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.blog.mixin.UserMixin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class UserTest {
    private User user;

    @Before
    public void setUp(){
        user = new User(123,"James",23,"Male",
                "james@gmail.com", "1234567890");
    }
    @After
    public void tearDown(){
        user = null;
    }

    @Test
    public void JacksonMixinAnnotationTest() throws JsonProcessingException{
        ObjectMapper objectMapper = buildMapper();
        objectMapper.addMixIn(User.class, UserMixin.class);
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println(json);

    }

    private static ObjectMapper buildMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibilityChecker(objectMapper.getSerializationConfig()
                .getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
        return objectMapper;
    }

}
