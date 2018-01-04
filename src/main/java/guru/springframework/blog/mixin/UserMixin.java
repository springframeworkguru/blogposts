package guru.springframework.blog.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class UserMixin {
    @JsonCreator
    public UserMixin(@JsonProperty Long id, @JsonProperty String name,
                     @JsonProperty int age, @JsonProperty String gender,
                     @JsonProperty String email, @JsonProperty String phoneNo) {

    }
}
