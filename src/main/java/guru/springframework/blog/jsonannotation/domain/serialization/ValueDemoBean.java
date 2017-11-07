package guru.springframework.blog.jsonannotation.domain.serialization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class ValueDemoBean {
    @JsonProperty
    private long personId = 123L;
    @JsonProperty
    private String  name = "James Clark";

    @JsonValue
    public String toJson(){
        return this.name+","+this.personId+","+this.toString();
    }

    @Override
    public String toString() {
        return "ValueDemoBean{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                '}';
    }
}
