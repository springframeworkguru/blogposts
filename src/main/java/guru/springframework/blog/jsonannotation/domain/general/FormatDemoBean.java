package guru.springframework.blog.jsonannotation.domain.general;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class FormatDemoBean {
    @JsonProperty("person-id")
    public long personId = 123L;
    @JsonProperty("name")
    public String  name = "James Clark";
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @JsonProperty("active-date")
    public Date activeDate;

    public FormatDemoBean() {
    }
    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }
}
