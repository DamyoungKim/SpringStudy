package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//("memberService2")
public class MemberServiceImpl implements MemberService {
// MemberServiceImpl MemberRepository(추상), MemoryMemberRepository(구체) 둘다 의존 -> DIP 위반.
	private final MemberRepository memberRepository;

	@Autowired // ac.getBean(MemberRepository.class)
	public MemberServiceImpl( MemberRepository memberRepository) {
		// TODO Auto-generated constructor stub
		this.memberRepository = memberRepository;
	}
			
	@Override
	public void join(Member member) {
		// TODO Auto-generated method stub
		memberRepository.save(member);
		
	}

	@Override
	public Member findMember(Long memberId) {
		// TODO Auto-generated method stub
		return memberRepository.findById(memberId);
	}
	// 테스트 용도.
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}
