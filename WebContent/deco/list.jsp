<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DECO 당신의 하루를 꾸미다</title>
</head>
<body>
	<div>
    <a href="home.deco">
      <img src="" alt="">
      <span>DECO</span>
    </a>
  </div>
  <div>
    <form action="list.deco" method="get">
      <label for="">카테고리</label>
      <input type="checkbox" name="cate1" value="Cafe">카페
      <input type="checkbox" name="cate2" value="restaurant">맛집
      <input type="checkbox" name="cate3" value="concert">공연/전시
      <input type="checkbox" name="cate4" value="experience">체험/이색데이트
      <input type="checkbox" name="cate5" value="experience">전체선택<br>
      <label for="">지역</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="checkbox" name="loca1" value="gangnam">강남
        <input type="checkbox" name="loca2" value="insadong">인사동
        <input type="checkbox" name="loca3" value="yunnam">연남
        <input type="checkbox" name="loca4" value="sangsu">상수
        <input type="checkbox" name="loca5" value="myungdong">명동
        <input type="checkbox" name="loca6" value="jonglo">종로
        <input type="checkbox" name="loca7" value="daehaklo">대학로
        <input type="checkbox" name="loca8" value="sungbuk">성북
        <input type="checkbox" name="loca9" value="dongdaemun">동대문
        <input type="checkbox" name="loca10" value="garosugil">가로수길 
        <input type="checkbox" name="loca11" value="garosugil">전체선택 <br>
        <input type="submit" value="검색">
        <input type="reset" value="초기화">
    </form>
  </div>
  <div>왜안돼왜안돼</div>
  <div>
    <c:forEach var="vo" items="${CafeList}">
    <ul>
    	<li>${vo.name }</li>
       <li>${vo.content }</li>
       <li>${vo.phone }</li>
       <li>${vo.addr }</li>
       <li>${vo.menu }</li>
       <li>${vo.grade }</li>
       <li>영업시간 : ${vo.opentime} ~ ${vo.closetime}</li>
       <li>${vo.location }</li>
    </ul>
    </c:forEach>
  </div>
</body>
</html>