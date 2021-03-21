package tacos.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/*
	 * 모델 데이터나 사용자 입력을 처리하지 않는 간단한 컨트롤러(=뷰 컨트롤러)의 경우
	 * 이와 같은 방법으로 컨트롤러를 정의할 수 있다.
	 * 
	 * WebMvcConfigurer 인터페이스의 addViewControllers()를 오버라이딩
	 * 
	 * 해당 클래스는 뷰 컨트롤러를 선언하기 위한 구성 클래스로, 기존의 HomeController를 대신한다.
	 * 
	 * */
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");	
	}
}
