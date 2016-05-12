package guru.springframework.blog.jsonwithjackson.jsonreader;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectMapperToMapDemoTest {

    @Test
    public void testReadJsonWithObjectMapper() throws Exception {
        ObjectMapperToMapDemo obj= new ObjectMapperToMapDemo();
        obj.readJsonWithObjectMapper();
    }
}