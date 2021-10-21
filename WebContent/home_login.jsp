<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DECO 당신의 하루를 꾸미다.</title>
</head>
<body>
  <h1>DECO</h1>
  <form action="loginAction.deco" method="post">
    <label for="">아이디 : </label>
    <input type="text" name="userId"><br>
    <label for="">비밀번호 : </label>
    <input type="password" name="password">
    <input type="submit" value="login">
    <div>아직 회원이 아니신가요?</div>
    <a href="member.deco">회원가입</a>
    <a href="cafe.deco?idx=1" class=" ">상세보기</a>
  </form>
</body>
</html>