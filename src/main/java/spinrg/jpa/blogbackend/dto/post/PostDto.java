package spinrg.jpa.blogbackend.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
