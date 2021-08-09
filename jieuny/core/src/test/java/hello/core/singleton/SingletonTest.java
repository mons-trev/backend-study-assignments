package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void puresingleton(){
        AppConfig appConfig= new AppConfig();
        MemberService memberService1= appConfig.memberService();
        MemberService memberService2= appConfig.memberService();
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singleton(){
        singleTonService singleTonService1= singleTonService.getInstance();
        singleTonService singleTonService2= singleTonService.getInstance();
        assertThat(singleTonService1).isSameAs(singleTonService2);
    }
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void springContainer(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1= ac.getBean("memberService", MemberService.class);
        MemberService memberService2= ac.getBean("memberService", MemberService.class);
        assertThat(memberService1).isSameAs(memberService2);
    }
}