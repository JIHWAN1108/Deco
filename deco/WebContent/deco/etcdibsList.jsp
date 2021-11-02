<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>DECO 당신의 하루를 꾸미다</title>
  <link rel="stylesheet" href="css/dibsList.css">
  <script src="https://kit.fontawesome.com/96c30f85d8.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="../top.jsp" %>
  <!-- List -->

  <div class="decoList">
    <div class="cateoryAndCheckbox">
      <nav class="category">
        <a href="cafeDibsList.deco">Cafe</a>
        <a href="foodDibsList.deco">Restaurant</a>
        <a href="showsDibsList.deco">Show</a>
        <a href="etcDibsList.deco">Activity</a>
      </nav>
      </div>
    <div class="searchResult">Activity 찜목록</div>
    <section class="lists">
    <c:forEach var="vo" items="${dibsEtc}" varStatus="status">
      <a class="list" href="etc.deco?eidx=${vo.eidx}">
        <img src="/eimage/${vo.outimage}" onerror="this.src='img/기본이미지.png'" alt="etc-out" class="img" width="150px" height="150px">
        <ul class="listContents">
          <li class="listName">${vo.name }</li>
          <li class="listText">${vo.menu }</li>
          <li>
            <ul class="locationAndReveiwAndGrade">
              <li>${vo.location }</li>
              <li>리뷰${reviewcnts[status.index]}</li>
              <li>평점${vo.grade}</li>
            </ul>
          </li>
        </ul>
      </a>
    </c:forEach>
   
    

    </section>
    
  </div>
  <script>

    function checkOnlyLocationAll(target){
      const choice = document.getElementsByName(`location`);
      choice.forEach(ch => ch.checked=false)
      target.checked=true;
    } 

    function noCheckLocationAll(target){
      const choice = document.getElementsByName(`locationAll`);
      choice.forEach(ch => ch.checked=false)
      target.checked = true;
    }

    </script>
    <div class="topBtn">
      <a href="#" title="위로 가기"><i class="fas fa-arrow-up"></i></a>
    </div>
    <%@ include file="../bottom.jsp" %>
</body>
</html>




