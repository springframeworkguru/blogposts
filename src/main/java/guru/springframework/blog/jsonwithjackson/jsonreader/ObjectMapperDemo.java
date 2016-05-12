package guru.springframework.blog.jsonwithjackson.jsonreader;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.blog.jsonwithjackson.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;

public class ObjectMapperDemo {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public Employee readJsonWithObjectMapper() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee emp = objectMapper.readValue(new File("employee.json"), Employee.class);
        logger.info(emp.toString());
        return emp;
    }

}
