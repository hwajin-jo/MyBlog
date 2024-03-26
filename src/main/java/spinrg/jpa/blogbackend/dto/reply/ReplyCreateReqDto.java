package spinrg.jpa.blogbackend.dto.reply;

import lombok.Data;

@Data
public class ReplyCreateReqDto {
    private String content;
    private Long member_id;
    private Long post_id;
}
