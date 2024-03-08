package spinrg.jpa.blogbackend.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spinrg.jpa.blogbackend.entity.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberUpdateReqDto {
    private String password;
    private Address address;
}
