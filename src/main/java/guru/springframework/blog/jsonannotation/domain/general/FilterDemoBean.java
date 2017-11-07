package guru.springframework.blog.jsonannotation.domain.general;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("customFilter")
public class FilterDemoBean {
    public long personId = 123L;
    public String  name = "James Clark";
    public String gender = "male";

}
