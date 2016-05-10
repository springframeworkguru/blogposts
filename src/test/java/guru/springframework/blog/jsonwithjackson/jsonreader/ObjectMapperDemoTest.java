package guru.springframework.blog.jsonwithjackson.jsonreader;

import guru.springframework.blog.jsonwithjackson.domain.Employee;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectMapperDemoTest {

    @Test
    public void testReadJson() throws Exception {
      ObjectMapperDemo objectMapperDemo=new ObjectMapperDemo();
      Employee employee= objectMapperDemo.readJsonWithObjectMapper();
      assertNotNull(employee);
    }
}