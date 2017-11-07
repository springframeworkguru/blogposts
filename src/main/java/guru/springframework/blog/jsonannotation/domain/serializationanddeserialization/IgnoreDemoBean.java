package guru.springframework.blog.jsonannotation.domain.serializationanddeserialization;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class IgnoreDemoBean {
    @JsonIgnore
    public long personId = 0;
    public String  name = "James Clark";

    @Override
    public String toString() {
        return "IgnoreDemoBean{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                '}';
    }
}
