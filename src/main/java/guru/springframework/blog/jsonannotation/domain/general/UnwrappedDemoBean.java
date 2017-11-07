package guru.springframework.blog.jsonannotation.domain.general;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class UnwrappedDemoBean {
    public static class Address {
        public String doorNumber = "12";
        public String streetName = "phase-1";
        public String pinCode = "123456";
        public String city = "New York";

        @Override
        public String toString() {
            return "Address{" +
                    "doorNumber='" + doorNumber + '\'' +
                    ", streetName='" + streetName + '\'' +
                    ", pinCode='" + pinCode + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }
    public long personId = 0;
    public String  name = "James Clark";
    @JsonUnwrapped
    public Address address = new Address();
}
