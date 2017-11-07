package guru.springframework.blog.jsonannotation.domain.serialization;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class RawValueDemoBean {
    public long personId = 0;
    public String  name = "James Clark";
    @JsonRawValue
    public String address = "{\"doorNumber\": 1234, \"street\": \"phase-1\", " +
            "\"city\": \"New York\"}";
}
