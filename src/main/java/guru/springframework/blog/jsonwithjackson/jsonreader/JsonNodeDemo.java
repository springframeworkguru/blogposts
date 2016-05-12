package guru.springframework.blog.jsonwithjackson.jsonreader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class JsonNodeDemo {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    JsonNode rootNode;
    ObjectMapper objectMapper;
    public JsonNodeDemo()throws IOException{
        objectMapper = new ObjectMapper();
        rootNode = objectMapper.readTree(new File("employee.json"));
    }
        public JsonNode readJsonWithJsonNode() throws JsonProcessingException {
        String prettyPrintEmployee = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        logger.info(prettyPrintEmployee+"\n");
        return rootNode;
    }
        public String readNameNode()
        {
            JsonNode nameNode=rootNode.path("name");
            String name=nameNode.asText();
            logger.info("\n----------------------------\nEmployee Name: "+name+"\n");
            return name;
        }
      public Map<String,String> readPersonalInformation() throws JsonProcessingException
       {
           JsonNode personalInformationNode = rootNode.get("personalInformation");
           Map<String, String> personalInformationMap = objectMapper.convertValue(personalInformationNode, Map.class);
           for (Map.Entry<String, String> entry : personalInformationMap.entrySet())
           {
               logger.info("\n----------------------------\n"+entry.getKey() + "=" + entry.getValue()+"\n");
           }
             return personalInformationMap;
       }

       public Iterator<JsonNode> readPhoneNumbers(){
           JsonNode phoneNumbersNode = rootNode.path("phoneNumbers");
           Iterator<JsonNode> elements = phoneNumbersNode.elements();
           while(elements.hasNext()){
               JsonNode phoneNode = elements.next();
               logger.info("\n----------------------------\nPhone Numbers = "+phoneNode.asLong());
           }
           return elements;
       }
}

