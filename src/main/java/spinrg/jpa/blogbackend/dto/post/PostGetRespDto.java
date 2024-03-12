package spinrg.jpa.blogbackend.dto.post;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spinrg.jpa.blogbackend.constant.ResultCode;
import spinrg.jpa.blogbackend.entity.Member;
import spinrg.jpa.blogbackend.entity.Post;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostGetRespDto {

    private ResultCode code;
    private String msg;
    private PostDto postDto;
//    private Long id;
//    private String author;
//    private String title;
//    private String content;
//    private LocalDateTime createDate;
//    private LocalDateTime modifyDate;
}
