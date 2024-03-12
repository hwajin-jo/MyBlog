package spinrg.jpa.blogbackend.dto.post;

import lombok.Data;

@Data
public class PostEditReqDto {
    private String title;
    private String content;
}
