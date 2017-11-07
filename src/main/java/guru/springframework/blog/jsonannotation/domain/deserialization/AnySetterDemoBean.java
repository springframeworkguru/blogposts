package guru.springframework.blog.jsonannotation.domain.deserialization;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class AnySetterDemoBean {
    public long personId = 123L;
    public String  personName = "James Clark";
    private Map<String, String> properties = new HashMap<String, String>();

    @JsonAnySetter
    public void setProperties(String key, String value){
        properties.put(key, value);
    }

    @Override
    public String toString() {
        return "AnySetterDemoBean{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", properties=" + properties +
                '}';
    }
}
