package spinrg.jpa.blogbackend.dto.member;

import lombok.Data;
import spinrg.jpa.blogbackend.entity.Address;

@Data
public class MemberCreateReqDto {
    private String name;
    private String email;
    private String password;
    private Address address;
}
