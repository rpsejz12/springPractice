package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.board.BoardDAO;

public class MainController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		BoardDAO bDAO = new BoardDAO();	

		ModelAndView mav = new ModelAndView();
		
		mav.addObject("datas", bDAO.board_selectDB_all());			
		mav.setViewName("main");
		return mav;
	}

}