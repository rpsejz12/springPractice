package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.board.BoardDAO;
import model.board.BoardVO;
import model.member.MemberVO;

public class InsertController  implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();

		BoardDAO bDAO=new BoardDAO();
		BoardVO bVO=new BoardVO();
		
		ModelAndView mav = new ModelAndView();
		
		bVO.setTitle(request.getParameter("title"));
		bVO.setContent(request.getParameter("content"));
		bVO.setId(((MemberVO)session.getAttribute("seUser")).getId());
		
		if(bDAO.board_insert(bVO)) {
			mav.setViewName("redirect:main.do");
		}
		else {
			mav.setViewName("redirect:insert.jsp");
		}
		return mav;
	}

}
