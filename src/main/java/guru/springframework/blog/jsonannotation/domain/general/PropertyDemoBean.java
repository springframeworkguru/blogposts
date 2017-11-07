package guru.springframework.blog.jsonannotation.domain.general;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PropertyDemoBean {
    @JsonProperty("person-id")
    public long personId = 123L;
    @JsonProperty("name")
    public String  name = "James Clark";

    @Override
    public String toString() {
        return "PropertyDemoBean{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                '}';
    }
}
