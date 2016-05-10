package guru.springframework.blog.jsonwithjackson.domain;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

public class Employee {

    private int id;
    private String name;
    private int age;
    private BigDecimal salary;
    private String designation;
    private Address address;
    private long[] phoneNumbers;
    private Map<String, String> personalInformation;

    /*Getter and Setter Methods*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(long[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Map<String, String> getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(Map<String, String> personalInformation) {
        this.personalInformation = personalInformation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n----- Employee Information-----\n");
        sb.append("ID: " + getId() + "\n");
        sb.append("Name: " + getName() + "\n");
        sb.append("Age: " + getAge() + "\n");
        sb.append("Salary: $" + getSalary() + "\n");
        sb.append("Designation: " + getDesignation() + "\n");
        sb.append("Phone Numbers: " + Arrays.toString(getPhoneNumbers()) + "\n");
        sb.append("Address: " + getAddress() + "\n");
        sb.append("Personal Information:" + getPersonalInformation() + "\n");
        sb.append("*****************************");
        return sb.toString();
    }
}