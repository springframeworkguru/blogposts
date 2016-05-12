package guru.springframework.blog.jsonwithjackson.jsonreader;


import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.blog.jsonwithjackson.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class ObjectMapperToMapDemo {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public void readJsonWithObjectMapper() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<?,?> empMap = objectMapper.readValue(new FileInputStream("employee.json"),Map.class);
        for (Map.Entry<?, ?> entry : empMap.entrySet())
        {
            logger.info("\n----------------------------\n"+entry.getKey() + "=" + entry.getValue()+"\n");
        }
    }
}
