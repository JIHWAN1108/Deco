<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::deco::cafe</title>
<%@ include file="../top.jsp" %>
<link rel="stylesheet" href="css/cafe.css">
  <script src="https://kit.fontawesome.com/96c30f85d8.js" crossorigin="anonymous"></script>
</head>
<body>
<section>
<div class="decoDetail">
    <nav class="category">
      <a href="cafeList.deco">Cafe</a>
      <a href="foodList.deco">Restaurant</a>
      <a href="showsList.deco">Show</a>
      <a href="etcList.deco">Activity</a>
    </nav>
<form action="cafeUpdate.deco?page=${page}"method="post">
<input type="hidden" value="${cafe.idx}" name="idx">
 <ul class="detailContents">
      <li class="detailTitle">
        <div class="detailName">${cafe.name}</div>
        <div class="detailText">${cafe.content}</div>
      </li>
      <li class="detailImg">
        <div class="outImg">
          <div class="detailName"><외부 사진></div>
          <img src="/cimage/${cafe.outimage}" alt="cafe_out">
        </div>
        <div class="inImg">
          <div class="detailName"><내부 사진></div>
          <img src="/cimage/${cafe.inimage}" alt="cafe_in">
        </div>
        
        
      </li>
      <li class="detailGrade">
        <div class="detailName">평점</div>
        <div>${cafe.grade}</div>
      </li>
      <li class="detailMenu">
        <div class="detailName">대표 메뉴</div>
        <ul class="menu"> <!--여기는 반복문으로 작성-->
        <c:forEach var="vo" items="${menuList }">
          <li class="detailText">${vo}</li>
        </c:forEach>
        </ul>
      </li>
      <li class="detailTime">
        <div class="detailName">운영 시간</div>
        <div class="detailText">${cafe.opentime} ~ ${cafe.closetime}</div>
      </li>
      <li class="detailPhone">
        <div class="detailName">연락처</div>
        <div class="detailText">${cafe.phone}</div>
      </li>
      <li class="detailAddr">
        <div class="detailName">위치정보</div>
        <div class="detailText">${cafe.addr}</div>
      </li>
      <li class="detailLocation">
        <div id="map" style="width:100%;height:350px;"></div>
      </li>
</ul>




<div class="detailBtns">
   <input type="submit" value="수정" class="button small">
   <input type="button" onclick="location.href='foodList.deco?page=${page}'" value="리스트" class="button small">
</form>
 <form action="dibsUpdate.deco">
    <input type="hidden" name="idx" value="${cafe.idx }">
    <input type="submit" value="찜목록 추가/삭제" class="button small">
 </form>
</div>





<div class="reviewBar">
      <div class="reviewCnt">리뷰(${reviewCnt })</div>
      <div class="reviewSubtitle">리뷰 작성</div>
    </div>
    <section class="makeReview">
      <form action="reviewInsert.deco?page=${page}"method="post" enctype="multipart/form-data">
        <input type="hidden" value="${cafe.idx}" name="idx">  <!-- 이 값이 에요?  넵 -->
        <input type="hidden" value="cafe" name="category">
        <input type="hidden" name="nickname" readonly value="${user.nickname}">
      <div class="makeReviewContents">
        <div class="makeReviewText"> 
          <textarea rows="6" cols="70" placeholder ="리뷰를 작성해주세요" class="input" name="content"required></textarea>
        </div>
        <div id="image_container"></div>
        <!-- 평점,사진버튼,완료버튼 -->
        <div class="makeReviewRight">
          <div class="makeReviewGrade">
            <div>평점</div>
            <div> 
              <input type="number" name="grade"class="gradeInput" max="5" min ="1" value="5" > 
            </div>
          </div>
          <div class="makeReviewChooseImg">
            <label for="pic"><i class="fas fa-image"></i></label>
            <input type="file" id="pic" name="pic" accept="image/*" onchange="setThumbnail(event);" style="display:none">
          </div>
          <input type="submit" value="완료" class="makeReviewBtn">
        </div>
      </div>
      </form>
    </section>

<section class="reviewLists">
<c:forEach var="re" items="${review}">
<div class="reviewList">
        <div class="reviewContents">
          <ul class="reviewNameGrade">
            <li>${re.nickname}</li>
            <li>
              <span>평점 : </span>
              <span>${re.grade}</span>
<a href="javascript:deleteCmt('${re.idx}','${cafe.idx}','${re.grade}','${page}','${re.nickname}')">댓글삭제</a>
            </li>
          </ul>
          <div class="reviewText">
            ${re.content}
          </div>
        </div>
        <div>
          <img class="reviewImg" src="/reviewimage/${re.imgfile}" onerror="this.src='/srcimg/기본이미지.png'"></img>
        </div>  
      </div>
   </c:forEach>
      </section> 
   




<section>

<form action="reviewInsert.deco?page=${page}"method="post" enctype="multipart/form-data">
   <input type="hidden" value="${cafe.idx}" name="idx">  <!-- 이 값이 에요?  넵 -->
   <input type="hidden" value="cafe" name="category">
   <hr class="line">
   
 

 </form>
</section>
</div>
</section>
<script type="text/javascript">
function deleteCmt(reidx,idx,regrade,page,renickname){
      console.log(reidx);console.log(idx);
      
      const yn = confirm('댓글 삭제하시겠습니까?');
      if(yn){
         location.href='reviewInsert.deco?del=&reidx='+reidx+'&idx='+idx+'&regrade='+regrade+'&page='+page+'&renickname='+renickname;
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
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">${cafe.name}</div>'
        });
        infowindow.open(map, marker);
        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
   </script>
<!-- enctype="multipart/form-data" -->

</body>
<%@ include file="../bottom.jsp" %>
</html>