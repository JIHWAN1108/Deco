package com.deco.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.dao.CafeDao;
import com.deco.dto.Cafe;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CafeInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		
		CafeDao dao= CafeDao.getInstance();
		String path="c:\\upload/cafe";
	      int size=10*1024*1024; // 10MByte, 최대파일 크기
	      
	   try {
	      MultipartRequest multi_request = new MultipartRequest(request,path,size,"UTF-8",
	                                    new DefaultFileRenamePolicy());
	    String outimage = multi_request.getFilesystemName("outpic");		
	    String inimage = multi_request.getFilesystemName("intpic");		

		
		String name = multi_request.getParameter("name");
		String addr = multi_request.getParameter("addr");
		String location = multi_request.getParameter("location");
		String menu = multi_request.getParameter("menu");
		double grade= Double.parseDouble(multi_request.getParameter("grade"));
		String phone = multi_request.getParameter("phone");
		String opentime = multi_request.getParameter("opentime");
		String closetime = multi_request.getParameter("closetime");
		String content = multi_request.getParameter("content");
		
		Cafe dto= new Cafe();
		dto.setName(name);
		dto.setAddr(addr);
		dto.setLocation(location);
		dto.setMenu(menu);
		dto.setGrade(grade);
		dto.setPhone(phone);
		dto.setOpentime(opentime);
		dto.setClosetime(closetime);
		dto.setContent(content);
		dto.setOutimage(outimage);
		dto.setInimage(inimage);
		
		System.out.println(dto);
		
		dao.insert(dto);
	   }catch (Exception e) {
		   e.printStackTrace();
	}
		
		ActionForward foward =new ActionForward();
		foward.isRedirect = false;
		foward.url="list.deco";
		return foward;
	}

}