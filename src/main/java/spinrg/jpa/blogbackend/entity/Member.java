package spinrg.jpa.blogbackend.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    private String email;
    private String password;

    @Embedded
    Address address;

    public Member(String name, String email, String password, Address address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }
}
