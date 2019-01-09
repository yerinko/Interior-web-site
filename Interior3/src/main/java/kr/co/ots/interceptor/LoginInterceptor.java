package kr.co.ots.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		Object loginVO = modelAndView.getModel().get("login");

		if (loginVO != null) { // 로그인 안되어있으면 로그인창으로 다시 돌아가요
			System.out.println(" 로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("login", loginVO);
		}
	}
}
