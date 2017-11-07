package guru.springframework.blog.jsonannotation.domain.serialization;

import com.fasterxml.jackson.annotation.JsonGetter;

public class GetterDemoBean {
    public long personId = 123L;
    public String  personName = "James Clark";

    @JsonGetter(value = "person-id")
    public long getPersonId() {
        return personId;
    }
    @JsonGetter(value = "person-name")
    public String getPersonName() {
        return personName;
    }
}
