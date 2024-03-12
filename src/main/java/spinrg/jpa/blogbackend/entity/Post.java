package spinrg.jpa.blogbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
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

    public Post(Member member, String title, String content, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.member = member;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    public void update(String title, String content, LocalDateTime modifyDate) {
        this.title = title;
        this.content = content;
        this.modifyDate = modifyDate;
    }
}
