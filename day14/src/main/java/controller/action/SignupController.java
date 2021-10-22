package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.member.MemberDAO;
import model.member.MemberVO;

public class SignupController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		MemberDAO mDAO=new MemberDAO();
		MemberVO mVO= new MemberVO();
		ModelAndView mav = new ModelAndView();
		
		mVO.setId(request.getParameter("id"));
		mVO.setPw(request.getParameter("pw"));
		mVO.setName(request.getParameter("name"));
		
		
		if(mDAO.signup(mVO)) {
			mav.setViewName("redirect:login.jsp");
		}
		else {
			mav.setViewName("redirect:signup.jsp");
		}
		return mav;
	}

}
