package spinrg.jpa.blogbackend.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spinrg.jpa.blogbackend.constant.ResultCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateRespDto {
    private ResultCode code;
    private String msg;
}
