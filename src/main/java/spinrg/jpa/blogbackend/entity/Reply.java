//package spinrg.jpa.blogbackend.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Entity
//@NoArgsConstructor
//@Getter
//public class Reply {
//
//    @Id @GeneratedValue
//    @Column(name = "comment_id")
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    private Member member;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "post_id")
//    private Post post;
//
//    private String content;
//    private LocalDateTime createDate;
//    private LocalDateTime updateDate;
//
//    public Reply(Member member, Post post, String content, LocalDateTime createDate, LocalDateTime updateDate) {
//        this.member = member;
//        this.post = post;
//        this.content = content;
//        this.createDate = createDate;
//        this.updateDate = updateDate;
//    }
//}
