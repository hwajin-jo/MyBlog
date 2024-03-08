package spinrg.jpa.blogbackend.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spinrg.jpa.blogbackend.constant.ResultCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberUpdateRespDto {
    private ResultCode code;
    private String msg;
}
