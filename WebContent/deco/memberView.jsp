<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day3 [2]-회원 등록</title>
<!-- 스타일 참고  -->
<script>
	function validCheck() {
		const frm = document.frmReg;
		//1. 패스워드는 8글자 이상이어야 한다.
		if (frm.password.value.length < 8){
			alert('패스워드는 8글자 이상으로 하세요.');
			frm.password.focus();				// 포커스(커서) 이동 
			return false;						//함수가 종료.
		}
		//2. 나이 : 태그 min,max 무시 -> 20 ~ 70 값 범위로 검사합니다.
		if(frm.age.value < 1 || frm.age.value > 70 ){    //  return false 할 조건으로 작성. 이 위치는 위의 조건이 거짓일 때만 실행됩니다. 
			alert('나이는 20세 이상 70세 이하로만 가능합니다. ');
			frm.age.focus();
			return false;
		}
		
		//체크한것 이 한개도 없으면 여기와서 실행합니다.
		
		return false;
	}
	
</script>
</head>
<body>
	<div style="width: 70%; margin: auto;">
		<h3>회원 등록</h3>
		<form action="memberAction.deco" name="frmReg" method="post">
			<table style="width: 100%">
				<tr>
					<td><label>이름</label></td>
					<!--  required 필수 입력  , readonly : 읽기만.-->
					<td><input type="text" name="name" placeholder="이름 이력(필수)"
						required></td>
				</tr>
				<tr>
					<td><label>패스워드</label></td>
					<td><input type="password" name="password" placeholder="password을 입력하세요"></td>
				</tr>
				<tr>
					<td><label>이메일</label></td>
					<td><input type="email" name="email" placeholder="email을 입력하세요"></td>
				</tr>
				<tr>
					<td><label>성별</label></td>
					<td><input type="radio" value="남" name="gender">남자
						<input type="radio" value="여" name="gender" checked>여자
						<!-- checked  는 기본 선택 --></td>
				</tr>
				<tr>
					<td><label>나이</label></td>
					<td><input type="number" name="age" min="10" max="99"
						value="30"></td>
					<!-- value는 기본값. type="number" 일 때는 min,max 속성 설정 가능.-->
				</tr>
				<tr>
					<td><label>전화번호</label></td>
					<td><input type="text" name="phone" placeholder="전화번호을 입력하세요"></td>
				</tr>
				<tr>
					<td><label>주소</label></td>
					<td><select name="addr" id="addr_select">
							<!-- value 속성은 서버에 전달시킬 값 -->
							<option value="서울 강남구" selected>서울 강남구</option>
							<option value="서울 강서구" >서울 강서구</option>
							<option value="서울 강북구">서울 강북구</option>
							<option value="서울 강동구">서울 강동구</option>
							<option value="서울 종로구">서울 종로구</option>
					</select> 
					<!-- <span id="addr_id"><input type="text" name="addr_etc" disabled="disabled" 
							placeholder="기타 지역을 입력하세요." >
					</span> --></td>
				</tr>
				<tr>
					<td><label>닉네임</label></td>
					<td><input type="text" name="nickname" placeholder="닉네임을 입력하세요"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center"><input
						type="submit" value="가입하기"> <!-- submit : 서버에게 데이터를 제출 (form action 속성값에 설정된 url 로 데이터 전달.)
						action 이 .html 은 데이터 전송확인은 못합니다. url 이동만 확인!!--> <input
						type="reset" value="다시쓰기"></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
	document.getElementById("addr_select").addEventListener("change",function(){
		if(this.value=="기타"){ //this는 getElementById("addr_select")요소
//			document.getElementById("addr_id").style.display="inline-block";
			document.frmReg.addr_etc.disabled=false;
		}else {
//			document.getElementById("addr_id").style.display="none";
			document.frmReg.addr_etc.disabled=true;
		}
		
	});
	</script>
</body>
</html>