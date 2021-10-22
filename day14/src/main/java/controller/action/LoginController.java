package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.member.MemberDAO;
import model.member.MemberVO;

public class LoginController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		MemberDAO mDAO=new MemberDAO();
		MemberVO mVO=new MemberVO();
		
		ModelAndView mav = new ModelAndView();
		
		mVO.setId(request.getParameter("id"));
		mVO.setPw(request.getParameter("pw"));
		
		mVO = mDAO.login(mVO);
		
		if(mVO!=null) {
			session.setAttribute("seUser", mVO);
			mav.setViewName("redirect:main.do");
		}
		else {
			mav.setViewName("redirect:login.jsp");
		}
		
		
		return mav;
	}

}
