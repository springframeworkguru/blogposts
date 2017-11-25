package guru.springframework.blog.jsonprettyprinting.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class JsonPrettyPrintDemoBean {
    public long personId = 123L;
    public String  personName = "James Clark";

    @JsonGetter(value = "person-id")
    public long getPersonId() {
        return personId;
    }
    @JsonSetter("person-id")
    public void setPersonId(long personId) {
        this.personId = personId;
    }
    @JsonGetter(value = "person-name")
    public String getPersonName() {
        return personName;
    }
    @JsonSetter("person-name")
    public void setPersonName(String personName) {
        this.personName = personName;
    }
    @Override
    public String toString() {
        return "JsonPrettyPrintDemoBean{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                '}';
    }
}
