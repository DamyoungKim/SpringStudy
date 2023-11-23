package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
/*
 * 실제 동작에 필요한 구현 객체를 생성한다.
 * 객체의 생성과 연결은 AppConfig가 담당한다.
 * 
 * 
 * 리펙토링
 * 역할에 따른 구현에 따라 애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악할 수 있다.
 */

public class AppConfig {

	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository()); // 생성자 주입!
	}
	
	private MemberRepository memberRepository() {
		return new MemoryMemberRepository(); // 생성자 주입!
	}
	
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPloicy());
	}
	
	public DiscountPolicy discountPloicy() {
		return new FixDiscountPolicy();
	}
}
