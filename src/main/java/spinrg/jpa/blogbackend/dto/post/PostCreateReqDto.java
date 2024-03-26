package spinrg.jpa.blogbackend.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateReqDto {
    private String title;
    private String content;
    private Long member_id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
