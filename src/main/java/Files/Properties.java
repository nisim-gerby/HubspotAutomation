package Files;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Properties {

    private String company;
    private String email;
    private String firstname;
    private String lastname;
    private String phone;
    private String website;

    public Properties(String company, String email, String firstname, String lastname, String phone, String website) {
        this.company = company;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.website = website;
    }
}



