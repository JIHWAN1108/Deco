package com.deco.controller.action;

import java.io.IOException; 
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.dao.CafeDao;
import com.deco.dao.EtcDao;
import com.deco.dao.FoodDao;
import com.deco.dao.ShowsDao;
import com.deco.dto.Cafe;
import com.deco.dto.Etc;
import com.deco.dto.Food;
import com.deco.dto.Shows;

public class BestAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward =new ActionForward();
		

		
		CafeDao Cdao = CafeDao.getInstance();
		FoodDao Fdao = FoodDao.getInstance();
		ShowsDao Sdao = ShowsDao.getInstance();
		EtcDao Edao = EtcDao.getInstance();
		
		List<Cafe> Clist = Cdao.getCafeBest();
		List<Food> Flist = Fdao.getFoodBest();
		List<Shows> Slist = Sdao.getShowsBest();
		List<Etc> Elist = Edao.getEtcBest();
		
		request.setAttribute("CafeList",Clist);
		request.setAttribute("FoodList",Flist);
		request.setAttribute("ShowsList",Slist);
		request.setAttribute("EtcList",Elist);
		forward.isRedirect = false;
		forward.url="deco/best.jsp";
		return forward;
	}

}