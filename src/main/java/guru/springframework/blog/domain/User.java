package guru.springframework.blog.domain;

public class User {
    private long id;
    private String name;
    private int age;
    private String gender;
    private String email;
    private String phoneNo;

    public User(long id, String name, int age, String gender, String email, String phoneNo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo=" + phoneNo +
                '}';
    }
}
