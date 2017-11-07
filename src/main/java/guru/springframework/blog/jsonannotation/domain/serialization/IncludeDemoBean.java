package guru.springframework.blog.jsonannotation.domain.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class IncludeDemoBean {
    public long personId = 123L;
    public String  name = null;

    @Override
    public String toString() {
        return "IncludeDemoBean{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                '}';
    }
}
