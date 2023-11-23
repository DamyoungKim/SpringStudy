package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

//	private final MemberRepository memberRepository = new MemoryMemberRepository();
//	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//	private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
	/*
	 * Client : OrderServiceImpl 는 
	 * DiscountPoliy 인터페이스 뿐만 아니라
	 * FixDiscountPolicy 구현 클래스에도 의존하고 있다.
	 * 
	 * 추상에만 의존해야하는데 추상 + 구체 의존. -> DIP 위반.
	 * 
	 * FixDiscountPolicy -> RateDiscountPolicy 변경하는 순간 OrderServiceImpl 코드 변경을 해야함. -> OCP 위반.
	 * 
	 * 어떻게 문제를 해결할 수 있을까?
	 * 
	 * 이전 코드는 남자 배우 (OrderServiceImpl)가 여자 배우를 선택하는 거다(FixDiscountPolicy) -> 기획자가 하는건데..
	 * 
	 * 공연 기획자가 나와야한다
	 * 배우는 대본만 보고 본인 역할만 하면 된다. 뭘 선택할건지는 기획자가 하는거다.
	 * 
	 * 그래서 AppConfig 등장!
	 * AppConfg : 애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스
	 * 
	 * 
	 * 
	 */
	
	private DiscountPolicy discountPolicy; // 이렇게 사중하게 만들면 된다. 추상에만 의존하므로 DIP 해결 가능.
	// 근데 이거 null point 뜬다.. 인터페이스만 가지고 뭐 어케해.. 구체적인게 있어야지
	//이걸 해결하려면? 클라이언트인 OrderServiceImpld에 DiscountPolicy의 구현 객체를 누군가 대신 생성해줘서 대신 주입해주어야한다. 파라미터 전달??
	// 그걸 어떻게 할란가~~
	// 관심사의 분리.
	private MemberRepository memberRepository;
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		// TODO Auto-generated method stub
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice); //OCP 잘 지킨거. 할인 정책 바뀌면 discountPolicy만 바꾸면된다.
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
	public OrderServiceImpl(MemberRepository memberRepository,  DiscountPolicy discountPolicy) { // 뭐가 들어올지 모른다. 그냥 대본만 보고 공연 준비하는거야.
		// TODO Auto-generated constructor stub
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}
}
