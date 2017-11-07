package guru.springframework.blog.jsonannotation.domain.general;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;

public class BackReferenceDemoBean {
    public long personId = 123;
    public String  name = "John Thomas";
    @JsonBackReference
    public List<ManagedReferenceDemoBean> employees;

    public BackReferenceDemoBean(long personId, String name) {
        this.personId = personId;
        this.name = name;
        employees = new ArrayList<ManagedReferenceDemoBean>();
    }

    public void addEmployees(ManagedReferenceDemoBean managedReferenceDemoBean){
        employees.add(managedReferenceDemoBean);
    }
}
