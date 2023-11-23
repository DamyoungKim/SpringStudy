package hello.core.member;

public class MemberServiceImpl implements MemberService {
// MemberServiceImpl MemberRepository(추상), MemoryMemberRepository(구체) 둘다 의존 -> DIP 위반.
	private final MemberRepository memberRepository;

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

}
