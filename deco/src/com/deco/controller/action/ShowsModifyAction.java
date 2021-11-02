package com.deco.controller.action;

import java.io.IOException;  

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.ShowsDao;
import com.deco.dto.SessionDto;
import com.deco.dto.Shows;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ShowsModifyAction implements Action {

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
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		int pageNo =  Integer.parseInt(request.getParameter("page"));
		String path="c:\\upload/shows";
		int idx =0;
	      int size=10*1024*1024; 
	     
	      try {
		      MultipartRequest multi_request = new MultipartRequest(request,path,size,"UTF-8",
		                                    new DefaultFileRenamePolicy());
		   	
		      
		      String name = multi_request.getParameter("name");
		      idx=Integer.parseInt(multi_request.getParameter("sidx"));
				String addr = multi_request.getParameter("addr");
				String location = multi_request.getParameter("location");
				String menu1 = multi_request.getParameter("menu1");
				String menu2 = multi_request.getParameter("menu2");
				String menu3 = multi_request.getParameter("menu3");
				String price1 = multi_request.getParameter("price1");
				String price2 = multi_request.getParameter("price2");
				String price3 = multi_request.getParameter("price3");
				double grade= Double.parseDouble(multi_request.getParameter("grade"));
				String phone = multi_request.getParameter("phone");
				String opentime = multi_request.getParameter("opentime");
				String closetime = multi_request.getParameter("closetime");
				String content = multi_request.getParameter("content");
				String outimage = multi_request.getFilesystemName("outpic");		
				String link = multi_request.getFilesystemName("link");		
//			    String inimage = multi_request.getFilesystemName("intpic");	
				
				String menu = menu1+" : "+price1+"원/"+menu2+" : "+price2+"원/"+menu3+" : "+price3+"원";

		System.out.println(link);
		
		Shows dto = new Shows();
		dto.setSidx(idx);
		dto.setLocation(location);
		dto.setName(name);
		dto.setGrade(grade);
		dto.setContent(content);
		dto.setMenu(menu);
		dto.setOpentime(opentime);
		dto.setClosetime(closetime);
		dto.setAddr(addr);
		dto.setPhone(phone);
		dto.setOutimage(outimage);
//		dto.setInimage(inimage);
		dto.setLink(link);
		
		ShowsDao dao = ShowsDao.getInstance();
		dao.update(dto);
		System.out.println(dto);
	      }catch (Exception e) {
			   e.printStackTrace();
		}
	  System.out.println(idx);
		
		ActionForward foward =new ActionForward();
		foward.isRedirect = true;
		foward.url="shows.deco?sidx="+idx+ "&page="+pageNo;
		return foward;
		
	}



}
