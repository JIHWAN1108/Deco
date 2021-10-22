package com.deco.dto;

import lombok.Data;

@Data

public class PageDto {
	private int currentPage;		//현재 페이지
	private int totalCount; 		//글의 전체 객수
	private int pageSize;			// 한개페이지에 보여줄 글 갯수
	
	
	private int totalPage;			//전체 페이지 갯수
	private int startPage;			//
	private int endPage;			//꼭 필요한거 아니야;
	
	private int startNo;
	
	
	public PageDto(int currentPage, int totalCount, int pageSize) {	//외부(비지니스로직)에서 결정하고 전달되는 값.
		this.totalCount=totalCount;
		this.pageSize=pageSize;
		
		totalPage= (totalCount-1)/pageSize + 1;
		//현재 페이지 범위(1~totalPage)의 유효성을 체크
		this.currentPage=(currentPage> totalPage)? totalPage:currentPage;
		this.currentPage=(currentPage<1)? 1:currentPage;
		
		//mysql 의 limit 사용할때
		startNo=(this.currentPage-1)*pageSize;
		
		startPage= (this.currentPage-1)/5*5+1;		// 페이지 번호 리스틑 10개씩
		//현제 페이지가 57, startPage =51
		//현제 페이지가 7, startPage =1
		//현제 페이지가 156, startPage =151
		//현제 페이지가 160, startPage =151
		endPage=startPage+4;
		endPage=endPage > totalPage ? totalPage : endPage; //totalpage 보다 큰값에 대한 제한.
	}
}