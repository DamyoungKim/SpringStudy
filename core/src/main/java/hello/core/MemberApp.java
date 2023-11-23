package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

	public static void main(String[] args) {
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = new MemberServiceImpl();
//		MemberService memberService = appConfig.memberService();
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // AppConfig -> 스프링 사용 버전으로 변
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // 기본적으로 메서드 이름으로 들어감. (이름, 반환 타)
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		System.out.println("new member = " + member.getName());
		System.out.println("find member = " + findMember.getName());
	}
}
/*
 *
22:09:01.144 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'appConfig'
22:09:01.148 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'memberService'
22:09:01.160 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'memberRepository'
22:09:01.162 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'orderService'
22:09:01.165 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'discountPloicy'
 * 
 */