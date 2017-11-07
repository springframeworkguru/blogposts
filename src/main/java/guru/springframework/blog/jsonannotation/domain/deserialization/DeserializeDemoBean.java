package guru.springframework.blog.jsonannotation.domain.deserialization;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import guru.springframework.blog.jsonannotation.domain.custom.CustomDateDeserializer;

import java.util.Date;

public class DeserializeDemoBean {
    public long personId = 123L;
    public String  name = "James Clark";
    @JsonDeserialize(using = CustomDateDeserializer.class)
    public Date activeDate;

    @Override
    public String toString() {
        return "DeserializeDemoBean{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", activeDate=" + activeDate +
                '}';
    }
}
