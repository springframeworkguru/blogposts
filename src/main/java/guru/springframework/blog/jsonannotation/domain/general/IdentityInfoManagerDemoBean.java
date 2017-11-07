package guru.springframework.blog.jsonannotation.domain.general;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "personId")
public class IdentityInfoManagerDemoBean {
    public long personId = 123;
    public String  name = "John Thomas";
    public List<IdentityInfoEmployeeDemoBean> employees;

    public IdentityInfoManagerDemoBean(long personId, String name) {
        this.personId = personId;
        this.name = name;
        employees = new ArrayList<IdentityInfoEmployeeDemoBean>();
    }

    public void addEmployees(IdentityInfoEmployeeDemoBean identityInfoEmployeeDemoBean){
        employees.add(identityInfoEmployeeDemoBean);
    }
}
