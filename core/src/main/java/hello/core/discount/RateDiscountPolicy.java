package hello.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;

@Component
@Primary
/*
@Qualifier("mainDiscountPolicy")
@MainDiscountPolicy -> 가져다 쓰는 곳에서도 똑같이 어노테이션해주면 된다.
*/
public class RateDiscountPolicy implements DiscountPolicy {

	private int discountPercent = 10;
	@Override
	public int discount(Member member, int price) {
		// TODO Auto-generated method stub
		if (member.getGrade() == Grade.VIP) {
			return price * discountPercent / 100;
		}
		return 0;
	}

}
