package kr.co.ots.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//사용자 로그인 인증용 interceptor
// 로그인 되어 있지 않으면 사용자를 로그인 창으로 보내기
// servlet-context.xml 에서 /board/** 으로 접근 하는 모든 요청을 막아줄 예정 

public class AuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getSession().getAttribute("login") == null) {
			System.out.println("로그인 되어있지 않음");
			response.sendRedirect("/ots/user/loginForm.do");
			return false;		
		}
		return true;
	}
}
