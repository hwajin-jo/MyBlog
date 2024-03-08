package spinrg.jpa.blogbackend.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spinrg.jpa.blogbackend.constant.ResultCode;
import spinrg.jpa.blogbackend.entity.Member;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberGetRespDto {
    ResultCode code;
    String msg;
    List<Member> members;
}
