package guru.springframework.blog.jsonannotation.domain.deserialization;

import com.fasterxml.jackson.annotation.JsonSetter;

public class SetterDemoBean {
    public long personId = 0;
    public String  name = "James Clark";
    @JsonSetter("id")
    public void setPersonId(long personId) {
        this.personId = personId;
    }
    @Override
    public String toString() {
        return "SetterDemoBean{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                '}';
    }
}
