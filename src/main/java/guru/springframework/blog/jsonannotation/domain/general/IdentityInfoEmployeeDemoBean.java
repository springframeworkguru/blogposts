package guru.springframework.blog.jsonannotation.domain.general;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "personId")
public class IdentityInfoEmployeeDemoBean {
    public long personId = 0;
    public String  name = "James Clark";
    public IdentityInfoManagerDemoBean manager;

    public IdentityInfoEmployeeDemoBean(long personId, String name, IdentityInfoManagerDemoBean manager) {
        this.personId = personId;
        this.name = name;
        this.manager = manager;
    }
}
