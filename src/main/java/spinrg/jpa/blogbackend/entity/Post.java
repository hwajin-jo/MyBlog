package spinrg.jpa.blogbackend.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Post {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

}
