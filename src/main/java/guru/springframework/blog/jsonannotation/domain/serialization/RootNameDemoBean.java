package guru.springframework.blog.jsonannotation.domain.serialization;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "user")
public class RootNameDemoBean {
    public long personId = 0;
    public String  name = "James Clark";
}
