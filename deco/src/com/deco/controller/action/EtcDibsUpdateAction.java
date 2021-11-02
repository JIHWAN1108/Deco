package com.deco.controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.DibsDao;
import com.deco.dto.Dibs;
import com.deco.dto.SessionDto;



public class EtcDibsUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();

		HttpSession session = request.getSession();
		SessionDto sdto = (SessionDto)session.getAttribute("user");
		if(sdto==null) {
			request.setAttribute("message", "세션이 만료되었습니다. 로그인 화면으로 이동합니다.");
			request.setAttribute("url", "home_login.deco");
			forward.isRedirect = false;
			forward.url="error/alert.jsp";
			return forward;
		}
		
		DibsDao dibsdao = DibsDao.getInstance();
		int refidx = Integer.parseInt(request.getParameter("idx"));
		Map<String,String> map = new HashMap<String,String>();
		
		String message=null,url=null;
		
		// dibCafe 가져오기
		String nickname = sdto.getNickname();	// user 에서 닉네임
		Dibs dibs = dibsdao.getDibs(nickname);	// 닉네임으로 dibs 정보
		String dibEx = dibs.getDibEx();	// 요것이 dibFood 컬럼
		boolean isDibEx = dibEx.contains("/"+refidx+"/");
		
		if(!isDibEx) {		// false 이면 추가 !!
			if(dibEx==null) dibEx = "/";
			dibEx += refidx + "/";
			
			// dibs 테이블에 update 할 메소드 필요!
			map.put("dibEx", dibEx);
			map.put("nickname", nickname);
			dibsdao.updateEtcDibs(map);
			
			message="찜목록 추가 완료!";
			url="etc.deco?eidx="+refidx;
		}else {		// true 이면 삭제!!
			System.out.println(dibEx);
			dibEx = dibEx.replace("/"+refidx+"/", "/");	// ex "/123/" 삭제하고 "/"로 대체 
			System.out.println(dibEx);				// 원본이 안바껴서 다시 담아줌 ㅠㅠ
			
			map.put("dibEx", dibEx);
			map.put("nickname", nickname);
			dibsdao.updateEtcDibs(map);
			
			message="찜목록 삭제 완료!";
			url="etc.deco?eidx="+refidx;
		}
		
		request.setAttribute("message", message);
		request.setAttribute("url", url);
		forward.isRedirect=false;
		forward.url="error/alert.jsp";
		return forward;
	}

}
