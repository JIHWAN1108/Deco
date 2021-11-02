<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 찾기</title>
<!-- 스타일 참고  -->
<script> 
  function submit2(frm) { 
    frm.action='PassWordAction.deco'; 
    frm.submit(); 
    return true; 
  } 
</script> 
</head>
<body>
<%@ include file="../top.jsp" %>
<section>

<div>
			<form action="IdAction.deco" name="frmReg" method="post">	
<table>
				<tr>
					<td colspan="2" style="text-align: center">
					
					<input type="submit" value="아이디 찾기" ><td>
					<input type="text" name="name" placeholder="이름을 입력하세요" >
					<input type="number" name="phone" placeholder="전화번호을 입력하세요" ></td>
					
					</tr>
					</table>
					</form>
					</div>
					<!-- <div>
					<form>
					<table>
					<tr>
					<td>
					<input type='button' value='비밀번호 찾기' onclick='return submit2(this.form);'></td>
					<td>
					<input type="text" name="email" placeholder="아이디을 입력하세요" >
					<input type="text" name="name" placeholder="이름 을 입력하세요" >
					<input type="text" name="phone"  placeholder="전화번호 을 입력하세요" ></td>
				</tr>
			</table>
		</form>
		
	</div> -->
	</section>
<%@ include file="../bottom.jsp" %>
</body>
</html>