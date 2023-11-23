package hello.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicyTest {
	
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP는 10% 할인이 적용되어야 한다.")
	void vip_o() {
		// given
		Member member = new Member(1L, "memberVIP", Grade.VIP);
		//when
		int discount = discountPolicy.discount(member, 10000);
		//then
		Assertions.assertThat(discount).isEqualTo(1000);
		
	}
	
	@Test
	@DisplayName("VI가 아니면 할인이 적용되지 않아야 한다.")
	void vip_x() {
		// given
		Member member = new Member(1L, "memberBASIC", Grade.Basic);
		//when
		int discount = discountPolicy.discount(member, 10000);
		//then
		Assertions.assertThat(discount).isEqualTo(1000);
		
	}

}