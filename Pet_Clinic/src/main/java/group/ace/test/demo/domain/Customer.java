package group.ace.test.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private Integer age;
    // koga ke zacuvas customer, da zacuva i kontakt za soodvetniot customer
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Contact contact;
    //mapped by koristam posto ne e OnetoOne
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Pet> pets = new HashSet<>();

}
