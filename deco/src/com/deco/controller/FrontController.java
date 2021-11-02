package com.deco.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.controller.action.Action;
import com.deco.controller.action.ActionForward;
import com.deco.controller.action.Alert2;
import com.deco.controller.action.BestAction;
import com.deco.controller.action.CafeAction;
import com.deco.controller.action.CafeDibsListAction;
import com.deco.controller.action.CafeInsertAction;
import com.deco.controller.action.CafeListAction;
import com.deco.controller.action.CafeModifyAction;
import com.deco.controller.action.CafeUpdateAction;
import com.deco.controller.action.ChangeAction;
import com.deco.controller.action.DibsListAction;
import com.deco.controller.action.DibsUpdateAction;
import com.deco.controller.action.EtcAction;
import com.deco.controller.action.EtcDibsListAction;
import com.deco.controller.action.EtcDibsUpdateAction;
import com.deco.controller.action.EtcInsertAction;
import com.deco.controller.action.EtcListAction;
import com.deco.controller.action.EtcModifyAction;
import com.deco.controller.action.EtcReviewInsertAction;
import com.deco.controller.action.EtcUpdateAction;
import com.deco.controller.action.FoodAction;
import com.deco.controller.action.FoodDibsListAction;
import com.deco.controller.action.FoodDibsUpdateAction;
import com.deco.controller.action.FoodInsertAction;
import com.deco.controller.action.FoodListAction;
import com.deco.controller.action.FoodModifyAction;
import com.deco.controller.action.FoodReviewInsertAction;
import com.deco.controller.action.FoodUpdateAction;
import com.deco.controller.action.HomeLoginAction;
import com.deco.controller.action.IdAction;
import com.deco.controller.action.JoinAction;
import com.deco.controller.action.LoginAction;
import com.deco.controller.action.LogoutAction;
import com.deco.controller.action.PassWordAction;
import com.deco.controller.action.PassWordAction2;
import com.deco.controller.action.ReviewInsertAction;
import com.deco.controller.action.ReviewListAction;
import com.deco.controller.action.ShowsAction;
import com.deco.controller.action.ShowsDibsListAction;
import com.deco.controller.action.ShowsDibsUpdateAction;
import com.deco.controller.action.ShowsInsertAction;
import com.deco.controller.action.ShowsListAction;
import com.deco.controller.action.ShowsModifyAction;
import com.deco.controller.action.ShowsReviewInsertAction;
import com.deco.controller.action.ShowsUpdateAction;
import com.deco.controller.action.UserInfoAction;
import com.deco.controller.action.UserInfoDeleteAction;
import com.deco.controller.action.UserInfoModifyAction;
import com.deco.controller.action.UserInfoUpdateAction;

@WebServlet("*.deco")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward forward = null;
//		ActionForward forward = new ActionForward();
		
		String spath = request.getServletPath();
		System.out.println(spath);
//		forward.setRedirect(false);
//		forward.setUrl("./");
		String url="./";
		
		if(spath.equals("/home_login.deco")) {			//메인
			Action action = new HomeLoginAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/home.deco")) {		// 로그인 후 홈
			forward = new ActionForward(false, "home.jsp");
		}else if(spath.equals("/login.deco")) {
			Action action = new LoginAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/logout.deco")) {
			Action action = new LogoutAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/join.deco")) {		// 회원가입
			forward = new ActionForward(false, "deco/join.jsp");
		}else if(spath.equals("/mypage.deco")) {
			forward = new ActionForward(false, "deco/mypage.jsp");
			/*
			 * }else if(spath.equals("/userinfoUpdate.deco")) { forward = new
			 * ActionForward(false, "deco/userInfoUpdate.jsp"); }else
			 * if(spath.equals("/userinfo.deco")) { forward = new ActionForward(false,
			 * "deco/userInfo.jsp");
			 */
		}else if(spath.equals("/userInfo.deco")) {	// 회원 정보 받아서 userInfo.jsp
			Action action = new UserInfoAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/userInfoUpdate.deco")) {	// 회원 정보 받아서 userInfoUpdate.jsp
			Action action = new UserInfoUpdateAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/userInfoModify.deco")) {	// 회원 정보 수정 후 userInfo.jsp
			Action action = new UserInfoModifyAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/cafeList.deco")) {		// 카페 목록 검색
			Action action = new CafeListAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/cafe.deco")) {
			Action action = new CafeAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/joinAction.deco")) {	// 회원가입 완료 후 home_login.deco 로
			Action action = new JoinAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/userInfoDelete.deco")) {	// 회원 탈퇴
			Action action = new UserInfoDeleteAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/dibsList.deco")) {		// mypage에서 찜목록
			Action action = new DibsListAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/cafeUpdate.deco")) {	// 카페 정보 수정 -> cafeUpdate.jsp로
			Action action = new CafeUpdateAction();
			forward = action.execute(request, response);
		}else if(spath.contentEquals("/cafeModify.deco")){	//카페 정보 수정하고 다시 cafe.jsp로
			Action action = new CafeModifyAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/cafeInsert.deco")) {	// 카페 업체 등록 -> cafe.jsp로
			forward = new ActionForward(false,"deco/cafeInsert.jsp");
		}else if(spath.equals("/cafeInsertAction.deco")) {	// 카페 업ㅈ체 등록 완료 후 -> home.deco
			Action action = new CafeInsertAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/reviewList.deco")) {	// 리뷰목록
			Action action = new ReviewListAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/reviewInsert.deco")) {	// 리뷰작성(추가) 하고 -> cafe.jsp로
			Action action = new ReviewInsertAction();	// 여기서 카테고리 달라도 if문으로 리뷰 작성되게 구연할것!!
			forward = action.execute(request, response);
		}else if(spath.equals("/dibsUpdate.deco")) {	// 찜목록 추가/삭제
			Action action = new DibsUpdateAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/foodDibsUpdate.deco")) {	// 찜목록 추가/삭제
			Action action = new FoodDibsUpdateAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/showsDibsUpdate.deco")) {	// 찜목록 추가/삭제
			Action action = new ShowsDibsUpdateAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/etcDibsUpdate.deco")) {	// 찜목록 추가/삭제
			Action action = new EtcDibsUpdateAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/foodList.deco")) {      // 식당목록 검색
	         Action action = new FoodListAction();
	         forward = action.execute(request, response);
	      }else if(spath.equals("/food.deco")) {
	         Action action = new FoodAction();
	         forward = action.execute(request, response);
	      }else if(spath.equals("/foodUpdate.deco")) {   // 식당 정보 수정 -> foodUpdate.jsp로
	         Action action = new FoodUpdateAction();
	         forward = action.execute(request, response);
	      }else if(spath.equals("/foodInsertAction.deco")) {   // 식당 업체 등록 완료 후 -> home.deco
	         Action action = new FoodInsertAction();
	         forward = action.execute(request, response);
	      }else if(spath.equals("/foodInsert.deco")) {   // 식당 업체 등록 -> 
	         forward = new ActionForward(false,"deco/foodInsert.jsp");
	      }else if(spath.contentEquals("/foodModify.deco")){	//식당 정보 수정하고 다시 food.jsp로
			Action action = new FoodModifyAction();
			forward = action.execute(request, response);
		  }else if(spath.contentEquals("/foodReviewInsert.deco")){	//식당 정보 수정하고 다시 food.jsp로
			Action action = new FoodReviewInsertAction();
			forward = action.execute(request, response);
		  }else if(spath.equals("/showsList.deco")) {      // 식당목록 검색
	         Action action = new ShowsListAction();
	         forward = action.execute(request, response);
	      }else if(spath.equals("/shows.deco")) {
	         Action action = new ShowsAction();
	         forward = action.execute(request, response);
	      }else if(spath.equals("/showsUpdate.deco")) {   // 식당 정보 수정 -> foodUpdate.jsp로
	         Action action = new ShowsUpdateAction();
	         forward = action.execute(request, response);
	      }else if(spath.equals("/showsInsertAction.deco")) {   // 식당 업체 등록 완료 후 -> home.deco
	         Action action = new ShowsInsertAction();
	         forward = action.execute(request, response);
	      }else if(spath.equals("/showsInsert.deco")) {   // 식당 업체 등록 -> 
	         forward = new ActionForward(false,"deco/showsInsert.jsp");
	      }else if(spath.contentEquals("/showsModify.deco")){	//식당 정보 수정하고 다시 food.jsp로
			Action action = new ShowsModifyAction();
			forward = action.execute(request, response);
		  }else if(spath.contentEquals("/showsReviewInsert.deco")){	//식당 정보 수정하고 다시 food.jsp로
			Action action = new ShowsReviewInsertAction();
			forward = action.execute(request, response);
		  }else if(spath.equals("/etcList.deco")) {      // 식당목록 검색
	         Action action = new EtcListAction();
	         forward = action.execute(request, response);
	      }else if(spath.equals("/etc.deco")) {
	         Action action = new EtcAction();
	         forward = action.execute(request, response);
	      }else if(spath.equals("/etcUpdate.deco")) {   // 식당 정보 수정 -> foodUpdate.jsp로
	         Action action = new EtcUpdateAction();
	         forward = action.execute(request, response);
	      }else if(spath.equals("/etcInsertAction.deco")) {   // 식당 업체 등록 완료 후 -> home.deco
	         Action action = new EtcInsertAction();
	         forward = action.execute(request, response);
	      }else if(spath.equals("/etcInsert.deco")) {   // 식당 업체 등록 -> 
	         forward = new ActionForward(false,"deco/etcInsert.jsp");
	      }else if(spath.contentEquals("/etcModify.deco")){	//식당 정보 수정하고 다시 food.jsp로
			Action action = new EtcModifyAction();
			forward = action.execute(request, response);
		  }else if(spath.contentEquals("/etcReviewInsert.deco")){	//식당 정보 수정하고 다시 food.jsp로
			Action action = new EtcReviewInsertAction();
			forward = action.execute(request, response);
		  }else if(spath.equals("/insertButton.deco")) {	// 카페 업체 등록 -> cafe.jsp로
				forward = new ActionForward(false,"deco/insertButton.jsp");
			}else if(spath.contentEquals("/best.deco")){	//금주의 핫플로
				Action action = new BestAction();
				forward = action.execute(request, response);
			}else if(spath.equals("/password.deco")) {
		    	   forward = new ActionForward(false,"deco/password.jsp");
			}else if(spath.equals("/password2.deco")) {
		    	   forward = new ActionForward(false,"deco/password2.jsp");
			}else if(spath.equals("/IdAction.deco")) {
				Action action = new IdAction();
				forward = action.execute(request, response);
			}else if(spath.equals("/PassWordAction.deco")) {
				Action action = new PassWordAction();
				forward = action.execute(request, response);
			}else if(spath.equals("/PassWordAction2.deco")) {
				Action action = new PassWordAction2();
				forward = action.execute(request, response);
			}else if(spath.equals("/change.deco")) {
				forward = new ActionForward(false,"deco/change.jsp");
			}else if(spath.equals("/ChangeAction.deco")) {
				Action action = new ChangeAction();
				forward = action.execute(request, response);
			}else if(spath.equals("/Alert2.deco")) {
				Action action = new Alert2();
				forward = action.execute(request, response);
			}else if(spath.equals("/cafeDibsList.deco")) {      // mypage에서 찜목록
	            Action action = new CafeDibsListAction();
	            forward = action.execute(request, response);
	         }else if(spath.equals("/foodDibsList.deco")) {      // mypage에서 찜목록
	            Action action = new FoodDibsListAction();
	            forward = action.execute(request, response);
	         }else if(spath.equals("/showsDibsList.deco")) {      // mypage에서 찜목록
	            Action action = new ShowsDibsListAction();
	            forward = action.execute(request, response);
	         }else if(spath.equals("/etcDibsList.deco")) {      // mypage에서 찜목록
	            Action action = new EtcDibsListAction();
	            forward = action.execute(request, response);
	         }else if(spath.equals("/restration.deco")) {
					forward = new ActionForward(false,"deco/restration.jsp");
	         }

		

		
		
		
		
		
		
		// 이 시점에서 forward 에 isREdirct 와 url 값이 저장되어있으면 OK!
				if(!forward.isRedirect()) {
					RequestDispatcher rd = request.getRequestDispatcher(forward.getUrl());
					rd.forward(request, response);
				}else {
					response.sendRedirect(forward.getUrl());
				} 
		
		}
}
