package spinrg.jpa.blogbackend.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Comment {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "post_id")
//    private Post post;

    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
