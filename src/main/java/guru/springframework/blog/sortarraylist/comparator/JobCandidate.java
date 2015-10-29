package guru.springframework.blog.sortarraylist.comparator;


import java.util.Comparator;

public class JobCandidate {
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

    public static Comparator<JobCandidate> ageComparator = new Comparator<JobCandidate>() {
        @Override
        public int compare(JobCandidate jc1, JobCandidate jc2) {
            return (jc2.getAge() < jc1.getAge() ? -1 :
                    (jc2.getAge() == jc1.getAge() ? 0 : 1));
          }
    };

    public static Comparator<JobCandidate> nameComparator = new Comparator<JobCandidate>() {
        @Override
        public int compare(JobCandidate jc1, JobCandidate jc2) {
            return (int) (jc1.getName().compareTo(jc2.getName()));
        }
    };


    @Override
    public String toString() {
        return " Name: " + this.name + ", Gender: " + this.gender + ", age:" + this.age;
    }
}
