package guru.springframework.blog.jsonannotation.domain.deserialization;

import com.fasterxml.jackson.annotation.JacksonInject;

public class JacksonInjectDemoBean {
    @JacksonInject
    public long personId = 0;
    public String  name = "James Clark";

    @Override
    public String toString() {
        return "JacksonInjectDemoBean{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                '}';
    }
}
