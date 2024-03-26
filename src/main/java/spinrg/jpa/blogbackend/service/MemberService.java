package spinrg.jpa.blogbackend.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spinrg.jpa.blogbackend.entity.Member;
import spinrg.jpa.blogbackend.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member findMemberById(Long id) {
        Optional<Member> findMember = memberRepository.findById(id);
        if (findMember.isEmpty()) {
            throw new IllegalStateException("잘못된 사용자 입니다.");
        }
        return findMember.get();
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Transactional
    public void createMember(Member member) {
        validateDuplication(member); // 중복 회원 검출
        memberRepository.save(member);
    }

    private void validateDuplication(Member member) {
        List<Member> memberList = memberRepository.findByEmail(member.getEmail());

        if (!memberList.isEmpty())
            throw new IllegalStateException("이미 존재하는 회원입니다.");
    }
}
