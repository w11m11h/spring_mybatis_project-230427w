package com.moohee.wboard.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moohee.wboard.dao.IDao;
import com.moohee.wboard.dto.WBoardDto;
import com.moohee.wboard.dto.WMemberDto;

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
		//�̹� ���Ե� ȸ���̸� 1, �ƴϸ� 0�� ��ȯ
		
		model.addAttribute("checkIdFlag", checkIdFlag);
		
		return "joinOk";
		
		}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/loginOk", method = RequestMethod.POST)
	public String loginOk(HttpServletRequest request, Model model, HttpSession session) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		int checkIdFlag = dao.checkIdDao(mid);
		
		model.addAttribute("checkIdFlag", checkIdFlag);
		
		int checkIdPwFlag = dao.checkIdPwDao(mid, mpw);
		
		model.addAttribute("checkIdPwFlag", checkIdPwFlag);
		
		if(checkIdPwFlag == 1) { //�α��� ����
//			HttpSession session = request.getSession(); //��Ʈ�ѷ����� ���ǰ�ü ��������
			session.setAttribute("sessionId", mid);
			model.addAttribute("memberId", mid);
		}
		
		return "loginOk";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		
		session.invalidate(); //��� ���� ����
		
		return "login";
	}
	
	@RequestMapping(value = "write_form")
	public String write_form(HttpSession session, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String sid = (String)session.getAttribute("sessionId");
		
		if(sid == null) {
			 return "redirect:login";
		} else {			
			WMemberDto dto = dao.getMemberInfo(sid);
			
			model.addAttribute("memberDto", dto);
			
			return "writeForm";			 
		}
	}
	
	@RequestMapping(value = "/write")
	public String write(HttpServletRequest request) {
		
		String wid = request.getParameter("mid");
		String wname = request.getParameter("mname");
		String wtitle = request.getParameter("wtitle");
		String wcontent = request.getParameter("wcontent");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.writeDao(wid, wname, wtitle, wcontent);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		ArrayList<WBoardDto> dtos = dao.listDao();
		
		model.addAttribute("list", dtos);
		
		int total = dao.totalBoardDao(); //�� �Խñ� �� 
		model.addAttribute("total", total); //�� �Խñ� �� ������
		
		return "list";
	}
	
	@RequestMapping(value = "/content_view")
	public String content_view(Model model, HttpServletRequest request, HttpSession session) {
		
		String wnum = request.getParameter("wnum");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		WBoardDto dto = dao.contentViewDao(wnum);
		
		String sessionId = (String) session.getAttribute("sessionId");
		
		if(sessionId == null) { //�α������� �������
			model.addAttribute("delCheck", "0");
		} else if(sessionId.equals(dto.getWid())) { //�α����� ���̵��� �۾����̵� ��ġ
			model.addAttribute("delCheck", "1");
		} else { //�α����� ���̵�� �۾����̵� ��ġ���� ���� ���
			model.addAttribute("delCheck", "0");
		}
		
		model.addAttribute("content", dto);
		
		return "contentView";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, HttpSession session, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.deleteDao(request.getParameter("wnum"));			
		
		return "redirect:list";
	}
	
}
