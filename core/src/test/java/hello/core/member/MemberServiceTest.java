package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
// junit 테스트 프레임 워크.
public class MemberServiceTest {
	MemberService memberService = new MemberServiceImpl();
	@Test
	void join() {
		// given
		Member member = new Member(1L, "memberA", Grade.VIP);
		
		// when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		// then
		Assertions.assertThat(member).isEqualTo(findMember);
	}

}
