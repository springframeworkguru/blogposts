package guru.springframework.blog.jsonannotation.domain.general;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class ManagedReferenceDemoBean {
    public long personId = 0;
    public String  name = "James Clark";
    @JsonManagedReference
    public BackReferenceDemoBean manager;

    public ManagedReferenceDemoBean(long personId, String name, BackReferenceDemoBean manager) {
        this.personId = personId;
        this.name = name;
        this.manager = manager;
    }
}
