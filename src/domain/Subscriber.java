package domain;

public class Subscriber {

    private Integer id;

    private String firstName;

    private String lastName;

    private String city;

    private Integer age;

    private String sex;

    public Subscriber(Integer id, String firstName, String lastName, String city, Integer age, String sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String toString() {
        return "ID: " + id + " | Name: " + firstName + " " + lastName + " | City: " + city + " | Age: " + age + " | Sex: " + sex;
    }

}
