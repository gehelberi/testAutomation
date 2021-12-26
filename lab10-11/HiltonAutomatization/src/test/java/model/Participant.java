package model;

public class Participant {
    private String firstName;
    private String lastName;
    private String phone;
    private String mail;
    private String country;
    private String address;
    private String city;
    private String password;
    private String confirmPassword;




    public Participant(String firstName, String lastName, String phone, String mail,
                       String address, String city, String password, String confirmPassword, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.city = city;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }


    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
