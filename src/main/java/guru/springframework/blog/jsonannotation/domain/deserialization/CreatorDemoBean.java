package guru.springframework.blog.jsonannotation.domain.deserialization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatorDemoBean {
    public long personId = 0;
    public String  name = "James Clark";

    @JsonCreator
    public CreatorDemoBean(@JsonProperty("id") long personId, @JsonProperty("name") String name) {
        this.personId = personId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CreatorDemoBean{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                '}';
    }
}
