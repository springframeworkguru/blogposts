package guru.springframework.blog.jsonannotation.domain.serialization;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;

public class AnyGetterDemoBean {
    public long personId = 123L;
    public String  personName = "James Clark";
    private Map<String, String> properties = new HashMap<String, String>();

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }
}
