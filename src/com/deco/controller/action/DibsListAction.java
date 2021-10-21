package com.deco.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.DibsDao;
import com.deco.dto.Cafe;
import com.deco.dto.Dibs;
import com.deco.dto.SessionDto;

public class DibsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 사용자 닉네임 이전 페이지에서 session으로 값 받아 넘겨주기 // request.getParameter로 받기
		HttpSession session = request.getSession();
		SessionDto user = (SessionDto)session.getAttribute("user");
		//String nickname = request.getParameter("nickname");
		String nickname = user.getNickname();
		
		DibsDao dao = DibsDao.getInstance();
		Dibs dibs = dao.getDibs(nickname);
		List<Cafe> listCafe = new ArrayList<Cafe>();
		
		String dibCafe = dibs.getDibCafe();
		System.out.println(dibCafe);	//시범 출력
		StringTokenizer dibsCafe = new StringTokenizer(dibCafe,"/");
		System.out.println(dibsCafe);
		while(dibsCafe.hasMoreTokens()) {	//다음 토큰이 있나?
			String idx = dibsCafe.nextToken(); // 토큰을 idx에 String 으로 담음
			Cafe cafe = dao.getCafeDibs(idx); 
			listCafe.add(cafe);
		}
		
		request.setAttribute("dibsCafe", listCafe);
		
		ActionForward forward = new ActionForward();
		forward.isRedirect=false;
		forward.url="deco/dibsList.jsp";
		return forward;
	}

}
