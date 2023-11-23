package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository = new MemoryMemberRepository();
//	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); 
	/*
	 * Clinet : OrderServiceImpl 는 
	 * DiscountPoliy 인터페이스 뿐만 아니라
	 * FixDiscountPolicy 구현 클래스에도 의존하고 있다.
	 * 
	 * 추상에만 의존해야하는데 추상 + 구체 의존. -> DIP 위반.
	 * 
	 * FixDiscountPolicy -> RateDiscountPolicy 변경하는 순간 OrderServiceImpl 코드 변경을 해야함. -> OCP 위반.
	 * 
	 * 어떻게 문제를 해결할 수 있을까?
	 */
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		// TODO Auto-generated method stub
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice); //OCP 잘 지킨거. 할인 정책 바뀌면 discountPolicy만 바꾸면된다.
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
}
