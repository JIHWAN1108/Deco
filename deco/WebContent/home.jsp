<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" href="css/home.css">
  <script src="https://kit.fontawesome.com/96c30f85d8.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="../top.jsp" %>
  <div class="decoHome">
    <div class="homeTitle">DECO</div>
    <section class="listBtn">
      <a href="cafeList.deco" class="blue"><div>Cafe</div></a>
      <a href="foodList.deco" class="green"><div>Restaurant</div></a>
      <a href="showsList.deco" class="pink"><div>Show</div></a>
      <a href="etcList.deco" class="purple"><div>Activity</div></a>
    </section>
    <section class="homeContents">
      <div>업체를 등록해보세요 <a href="insertBtn.deco">click <i class="fas fa-exclamation"></i></a></div>
      <div>다양한 데이트장소를 검색해보세요 <a href="cafeList.deco">click <i class="fas fa-exclamation"></i></a></div>
      <div>마음에 드는 장소를 찜목록에 추가해보세요 <a href="dibsList.deco">click <i class="fas fa-exclamation"></i></a></div>
      <div>금주의 핫플을 바로 만나보세요 <a href="best.deco">click <i class="fas fa-exclamation"></i></a></div>
    </section>
    <%@ include file="../bottom.jsp" %>
</body>
</html>