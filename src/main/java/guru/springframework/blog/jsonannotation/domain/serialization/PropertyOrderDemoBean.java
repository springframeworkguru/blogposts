package guru.springframework.blog.jsonannotation.domain.serialization;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "personId"})
public class PropertyOrderDemoBean {
    public long personId = 123L;
    public String  name = "James Clark";
}
