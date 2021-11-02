<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<!-- 스타일 참고  -->

</head>
<body>

<%@ include file="../top.jsp" %>

<section>
<div>
			<form action="ChangeAction.deco" name="frmReg" method="post">
			<input type="hidden" value="${map}" >	
<table>
				<tr>
					<td colspan="2" style="text-align: center">
					
					<input type="submit" value="비밀번호 설정 확인" onclick="PassWordCheck()" ><td>
					<input type="password" name="password" id="password" placeholder="새로운 비밀번호를 입력하세요" >
					<input type="password" name="password1" id="password1" placeholder="새로운 비밀번호를 확인하세요" ></td>
					
					
				</tr>
			</table>
		</form>
		
	</div>
</section>
<%@ include file="../bottom.jsp" %>

<script>
	function PassWordCheck(){
		const frm = document.frmReg;
		if(frm.password.value==""){
			alert("새로운 비밀번호를 입력해주세요");
			frm.password.focus();
			return;
		}
		if(frm.password1.value==""){
			alert("새로운 비밀번호를 입력해주세요");
			frm.password1.focus();
			return;
		}
		if(frm.password.value!=frm.password1.value){
			alert("비밀번호가 일치하지 않습니다.");
			frm.password.value="";
			frm.password1.value="";
			frm.password,focus();
			return;
		}
		frm.method="POST";
		frm.action="ChangeAction.deco";
		frm.submit();
	}

</script>
</body>
</html>