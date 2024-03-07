package spinrg.jpa.blogbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spinrg.jpa.blogbackend.constant.ResultCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberCreateRespDto {
    ResultCode code;
    String msg;
}
