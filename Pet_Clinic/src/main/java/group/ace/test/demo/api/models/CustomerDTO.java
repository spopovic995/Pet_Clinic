package group.ace.test.demo.api.models;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String telephone;
    private String address;
    private String secondaryEmail;
}
