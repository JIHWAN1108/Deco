package com.deco.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.dao.CafeDao;
import com.deco.dto.Cafe;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		int pageNo =  Integer.parseInt(request.getParameter("page"));
		String path="c:\\upload/cafe";
		int idx =0;
	      int size=10*1024*1024; 
	     
	      try {
		      MultipartRequest multi_request = new MultipartRequest(request,path,size,"UTF-8",
		                                    new DefaultFileRenamePolicy());
		   	
		      
	    idx=Integer.parseInt(multi_request.getParameter("idx"));
		String location= multi_request.getParameter("location");
		String name= multi_request.getParameter("name");
		double grade= Double.parseDouble(multi_request.getParameter("grade"));
		String content= multi_request.getParameter("content");
		String menu= multi_request.getParameter("menu");
		String opentime= multi_request.getParameter("opentime");
		String closetime= multi_request.getParameter("closetime");
		String addr= multi_request.getParameter("addr");
		String phone= multi_request.getParameter("phone");
		String outimage = multi_request.getFilesystemName("outimage");		
		String inimage = multi_request.getFilesystemName("inimage");
		
		
		Cafe dto = new Cafe();
		dto.setIdx(idx);
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
		dto.setInimage(inimage);
		
		
		CafeDao dao = CafeDao.getInstance();
		dao.update(dto);
		System.out.println(dto);
	      }catch (Exception e) {
			   e.printStackTrace();
		}
	  System.out.println(idx);
		
		ActionForward foward =new ActionForward();
		foward.isRedirect = true;
		foward.url="cafe.deco?idx="+idx+ "&page="+pageNo;
		return foward;
		
	}

}