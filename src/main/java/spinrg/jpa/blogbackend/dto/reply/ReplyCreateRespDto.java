package spinrg.jpa.blogbackend.dto.reply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spinrg.jpa.blogbackend.constant.ResultCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyCreateRespDto {
    private ResultCode code;
    private String msg;
}
