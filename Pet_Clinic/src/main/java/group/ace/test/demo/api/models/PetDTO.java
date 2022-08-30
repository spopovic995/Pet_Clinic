package group.ace.test.demo.api.models;

import group.ace.test.demo.domain.PetType;
import lombok.Data;

@Data
public class PetDTO {

    private String name;
    private String age;
    private PetType petType;
//    private String name1;
//    private String surname1;
//    private Integer age1;
//    private String email1;
//    private String telephone1;
//    private String address1;
//    private String secondaryEmail1;
}
