package guru.springframework.blog.jsonwithjackson.domain;

public class Address {
    private String street;
    private String city;
    private int zipCode;

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getZipCode() {
        return zipCode;
    }
    public void setZipcode(int zipcode) {
        this.zipCode = zipcode;
    }

    @Override
    public String toString(){
        return getStreet() + ", "+getCity()+", "+getZipCode();
    }
}
