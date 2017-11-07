package guru.springframework.blog.jsonannotation.domain.general;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

public class ViewDemoBean {
    @JsonView(Views.Public.class)
    @JsonProperty
    public long personId = 0;
    @JsonView(Views.Public.class)
    @JsonProperty
    public String  name = "James Clark";
    @JsonView(Views.Internal.class)
    @JsonProperty
    public String gender = "male";

    @Override
    public String toString() {
        return "ViewDemoBean{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
