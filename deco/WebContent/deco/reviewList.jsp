<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<title>::deco::리뷰목록</title>
<link rel="stylesheet" href="css/reviewList.css">
<body>
<%@ include file="../top.jsp" %>

<div class="decoDetail">
    <div class="reviewListTitle">리뷰 목록</div>

<section class="reviewLists">
<c:forEach var="vo" items="${ReviewList}">
	<div class="reviewList">
        <div class="reviewContents">
          <ul class="reviewNameGrade">
            <li>${vo.nickname}</li>
            <li>
              <span>평점</span>
              <span>${vo.grade }</span>
            </li>
            <c:if test="${vo.refidx ne 0 }">
            <li> <a href ="cafe.deco?idx=${vo.refidx}" class="listBtn">카페글 보기</a> </li> </c:if>
            <c:if test="${vo.fidx ne 0 }">
            <li> <a href ="food.deco?fidx=${vo.fidx}" class="listBtn">식당글 보기</a> </li> </c:if>
            <c:if test="${vo.sidx ne 0 }">
            <li> <a href ="shows.deco?sidx=${vo.sidx}" class="listBtn">공연글 보기</a> </li> </c:if>
            <c:if test="${vo.eidx ne 0 }">
            <li> <a href ="etc.deco?eidx=${vo.eidx}" class="listBtn">체험글 보기</a> </li> </c:if>
          </ul>
          <div class="reviewText">
            ${vo.content }
          </div>
        </div>
        <div>
          <img class="reviewImg" src="/reviewimage/${vo.imgfile}" onerror="this.src='img/기본이미지.png'"></img>
        </div>  
      </div>		
	</c:forEach>
	<%-- 
	<div>
	<form action="review.deco" method="get">
	<h3>리뷰리스트</h3>
	<c:forEach var="vo" items="${ReviewList}">
	<ul>
		<li>${vo.nickname }</li>
		<li>${vo.content }</li>
		<li>${vo.grade }</li>
		<li>${vo.category }</li>
		<li><img alt="cafe-out" src="/reviewimage/${vo.imgfile}" width="150px" height="150px"></li>
		<li> <a href ="cafe.deco?idx=${vo.refidx}">글 보러가기</a> </li>
	</ul>
	</c:forEach>
	</form>
	</div> --%>
	
	<c:if test="${pageDto.startPage!=1}">
			<a class="pagenum" href="?page=1">&lt;&lt;</a>
			<a class="pagenum" href="?page=${pageDto.startPage-1}">&lt;</a>
			<!-- startPage를 현재 startPage -10 -->
			<!-- 현재페이지를 startPage값에서 -1로 변경하면 요청이 변경되면서 자동 계산 -->
		</c:if>
	
	<div class="pagebutton">
		<c:forEach var="i" begin="${pageDto.startPage}"
			end="${pageDto.endPage}">
			<a
				class="pagenum
      	<c:if test="${pageDto.currentPage == i}">current</c:if>
      "
				href="?page=${i}">${i}</a>
		</c:forEach>

		<c:if test="${pageDto.endPage!=pageDto.totalPage}">
			<a class="pagenum" href="?page=${pageDto.endPage+1}">&gt;</a>

			<a class="pagenum" href="?page=${pageDto.totalPage}">&gt;&gt;</a>
		</c:if>
	</div>
</section>
</div>

<%@ include file="../bottom.jsp" %>
 <script type="text/javascript">
    function deleteCmt(reidx,idx,regrade,page){
          console.log(reidx);console.log(idx);
          
          const yn = confirm('댓글 삭제하시겠습니까?'+regrade);
          if(yn){
             location.href='review.deco?del=&reidx='+reidx+'&idx='+idx+'&regrade='+regrade+'&page='+page;
          }else{
             alert('댓글 삭제 취소합니다.');
          }
          
       }
       
    function setThumbnail(event) {
       var reader = new FileReader(); 
       reader.onload = function(event) { 
       var img = document.createElement("img"); 
       img.setAttribute("src", event.target.result);
       document.querySelector("div#image_container").appendChild(img); }; 
       reader.readAsDataURL(event.target.files[0]); }   
       
    </script>
    
    
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=888c3224d5235ea01a4b58cb939e595b&libraries=services"></script>
    <script>
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        mapOption = {
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };  
    // 지도를 생성합니다    
    var map = new kakao.maps.Map(mapContainer, mapOption); 
    // 주소-좌표 변환 객체를 생성합니다
    var geocoder = new kakao.maps.services.Geocoder();
    // 주소로 좌표를 검색합니다
                            //수정함!!!!!!!
    geocoder.addressSearch('${cafe.addr}', function(result, status) {
        // 정상적으로 검색이 완료됐으면 
         if (status === kakao.maps.services.Status.OK) {
            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new kakao.maps.Marker({
                map: map,
                position: coords
            });
            // 인포윈도우로 장소에 대한 설명을 표시합니다
            var infowindow = new kakao.maps.InfoWindow({                            //여기도 수정
                content: '<div style="width:150px;text-align:center;padding:6px 0;">${name}</div>'
            });
            infowindow.open(map, marker);
            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
        } 
    });    
       </script>
<div class="topBtn">
        <a href="#" title="위로 가기"><i class="fas fa-arrow-up"></i></a>
      </div>
</body>
</html>