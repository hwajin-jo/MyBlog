package spinrg.jpa.blogbackend.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spinrg.jpa.blogbackend.entity.Member;
import spinrg.jpa.blogbackend.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findOne(String name) {
        return memberRepository.findByName(name);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Transactional
    public void createMember(Member member) {
        validateDuplication(member); // 중복 회원 검출
        memberRepository.insertMember(member);
    }

    private void validateDuplication(Member member) {
        List<Member> memberList = memberRepository.findByEmail(member.getEmail());

        if (!memberList.isEmpty())
            throw new IllegalStateException("이미 존재하는 회원입니다.");
    }
}
