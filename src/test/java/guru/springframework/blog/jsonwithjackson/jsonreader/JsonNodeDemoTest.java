package guru.springframework.blog.jsonwithjackson.jsonreader;

import com.fasterxml.jackson.databind.JsonNode;
import guru.springframework.blog.jsonwithjackson.domain.Address;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

public class JsonNodeDemoTest {
    @Test
    public void testReadJsonWithJsonNode() throws Exception {
       JsonNodeDemo jsonNodeDemo=new JsonNodeDemo();
        JsonNode rootNode=jsonNodeDemo.readJsonWithJsonNode();
        assertNotNull(rootNode);
        String name=jsonNodeDemo.readNameNode();
        assertEquals("Henry Smith", name);
        Map<String, String> addressMap=jsonNodeDemo.readPersonalInformation();
        assertEquals(2, addressMap.size());
        Iterator<JsonNode> elements=jsonNodeDemo.readPhoneNumbers();
        assertNotNull(elements);

    }


}