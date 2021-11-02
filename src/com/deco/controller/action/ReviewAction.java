package com.deco.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.dao.CafeDao;
import com.deco.dao.ReviewDao;
import com.deco.dto.Cafe;
import com.deco.dto.Review;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ReviewDao dao = ReviewDao.getInstance();
		CafeDao Cdao = CafeDao.getInstance();

		int refidx = 0;
		double cgrade = 0;
		String path = "c:\\upload";
		int size = 10 * 1024 * 1024;

		int pageNo =  Integer.parseInt(request.getParameter("page"));
		if (request.getParameter("del") != null) {
			int reidx = Integer.parseInt(request.getParameter("reidx")); // 이건 삭제할 댓글 idx
			refidx = Integer.parseInt(request.getParameter("idx"));

			
			  Double grade= Double.parseDouble(request.getParameter("regrade"));
			  
			  
			  Cafe ca=Cdao.getOne(refidx); cgrade=ca.getGrade();
			  System.out.println(cgrade);
			  
			  List<Review> reList = dao.getReview(refidx);
			 
			  System.out.println(cgrade+"/"+grade+"/"+reList.size());
			  cgrade=(double)((cgrade*(reList.size()+1)-grade)/reList.size());
			  System.out.println(cgrade);
			  
			  Cafe cdto = new Cafe();
				cdto.setIdx(refidx);
				cdto.setGrade(cgrade);
				Cdao.gradeup(cdto);
			 
			dao.delete(reidx);
		} else {
			try {
				MultipartRequest multi_request = new MultipartRequest(request, path, size, "UTF-8",
						new DefaultFileRenamePolicy());
				String imgfile = multi_request.getFilesystemName("pic");

				refidx = Integer.parseInt(multi_request.getParameter("idx"));
				String category = multi_request.getParameter("category");
				String nickname = multi_request.getParameter("nickname");
				int grade = Integer.parseInt(multi_request.getParameter("grade"));
				String content = multi_request.getParameter("content");

				Review dto = new Review();
				dto.setRefidx(refidx);
				dto.setCategory(category);
				dto.setNickname(nickname);
				dto.setGrade(grade);
				dto.setContent(content);
				dto.setImgfile(imgfile);

				System.out.println(dto);

				dao.insert(dto);// 댓글 입력
				// 여기서부터 리뷰평균점수 구하기(댓글 입력 있을때만 작동)

				Cafe ca = Cdao.getOne(refidx);
				cgrade = ca.getGrade();

				List<Review> reList = dao.getReview(refidx);
				if(reList.size()!=1) {
				System.out.println(cgrade + "/" + grade + "/" + reList.size());
				cgrade = (double) ((cgrade * (reList.size() - 1) + grade) / reList.size());
				System.out.println(cgrade);
				}else {
				cgrade= (double)(cgrade+grade)/2;
				}

				Cafe cdto = new Cafe();
				cdto.setIdx(refidx);
				cdto.setGrade(cgrade);
				Cdao.gradeup(cdto);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		ActionForward foward = new ActionForward();
		foward.isRedirect = true;
		foward.url = "cafe.deco?idx=" + refidx+"&page="+pageNo;
		return foward;
	}

}