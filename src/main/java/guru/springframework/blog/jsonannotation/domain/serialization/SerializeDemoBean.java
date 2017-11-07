package guru.springframework.blog.jsonannotation.domain.serialization;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import guru.springframework.blog.jsonannotation.domain.custom.CustomDateSerializer;

import java.util.Date;

public class SerializeDemoBean {
    public long personId = 123L;
    public String  name = "James Clark";
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date activeDate;

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }
}
