package group.ace.test.demo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String age;
    @Enumerated(EnumType.STRING)
    private PetType petType;
    @ManyToOne
    private Customer owner;
}
