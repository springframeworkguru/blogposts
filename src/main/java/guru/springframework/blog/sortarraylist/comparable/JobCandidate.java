package guru.springframework.blog.sortarraylist.comparable;


public class JobCandidate implements Comparable<JobCandidate> {
    private String name;
    private String gender;
    private int age;

    public JobCandidate(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(JobCandidate candidate) {
        return (this.age - candidate.age);
    }

    @Override
    public String toString() {
        return " Name: " + this.name + ", Gender: " + this.gender + ", age:" + this.age;
    }
}
