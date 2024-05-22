package spinrg.jpa.blogbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
@Getter
public class Post {
    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

//    @OneToMany(mappedBy = "comment_id", fetch = LAZY, cascade = CascadeType.ALL)
//    private List<Reply> replyList = new ArrayList<>();

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
