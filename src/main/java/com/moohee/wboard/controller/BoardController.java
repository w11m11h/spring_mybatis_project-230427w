package com.moohee.wboard.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moohee.wboard.dao.IDao;

@Controller
public class BoardController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/joinMember")
	public String joinMember() {		
		return "joinMember";
	}
	
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	public String joinOk(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		int checkId = dao.checkIdDao(request.getParameter("mid"));
		
		if(checkId == 0) {
			dao.joinMemberDao(request.getParameter("mid"), request.getParameter("mpw"), request.getParameter("mname"), request.getParameter("memail"));			
			model.addAttribute("memberName", request.getParameter("mname"));
			model.addAttribute("checkIdFlag", "joinOk");
		} else {
			model.addAttribute("checkIdFlag", 1);
		}
		
		return "joinOk";
	}
	
	@RequestMapping(value = "/checkId")
	public String checkId(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);		
		
		int checkIdFlag = dao.checkIdDao(request.getParameter("checkId"));
		//이미 가입된 회원이면 1, 아니면 0이 반환
		
		model.addAttribute("checkIdFlag", checkIdFlag);
		
		return "joinOk";
		
		}
	
}
