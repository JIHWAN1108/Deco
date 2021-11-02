<%@page import="com.deco.dao.UsersDao"%>
<%@page import="com.deco.dto.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::deco::회원정보</title>
<!-- 스타일 참고  -->
<link rel="stylesheet" href="css/userInfoUpdate.css">
<script>
	function validCheck() {
		const frm = document.frmReg;
		//1. 패스워드는 8글자 이상이어야 한다.
		if (frm.password.value.length < 4){
			alert('패스워드는 4글자 이상으로 하세요.');
			frm.password.focus();				// 포커스(커서) 이동 
			return false;						//함수가 종료.
		}
		//2. 나이 : 태그 min,max 무시 -> 20 ~ 70 값 범위로 검사합니다.
		if(frm.age.value < 15 || frm.age.value > 70 ){    //  return false 할 조건으로 작성. 이 위치는 위의 조건이 거짓일 때만 실행됩니다. 
			alert('나이는 15세 이상 70세 이하로만 가능합니다. ');
			frm.age.focus();
			return false;
		}
	 
	    if(frm.name.value.length<2){
	        alert("이름을 2자 이상 입력해주십시오.")
	        frm.name.focus();
	        return false;
	    }
		
		//체크한것 이 한개도 없으면 여기와서 실행합니다.
		
		return false;
	}
	
	function findAddr(){
    	new daum.Postcode({
            oncomplete: function(data) {
            	
            	console.log(data);
            	
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var jibunAddr = data.jibunAddress; // 지번 주소 변수
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('member_post').value = data.zonecode;
                if(roadAddr !== ''){
                    document.getElementById("member_addr").value = roadAddr;
                } 
                else if(jibunAddr !== ''){
                    document.getElementById("member_addr").value = jibunAddr;
                }
            }
        }).open();
    }
	
</script>
</head>
<body>
<!--<c:if test="${alert!=null }">
	<script type="text/javascript">
		alert('회원 정보가 수정되었습니다.');
	</script>
</c:if>
-->
<form action="userInfoModify.deco" class="decoJoin" name="frmReg" method="post">
  <div class="decoJoinLogo">회원정보 수정</div>
    <ul class="joinContens">
      <li class="joinEmail">
        <div class="joinTitle">이메일(ID)</div>
        <input type="hidden" name="idx" value="${dto.idx }" >
        <input type="text" name="email" id="str_email01" class="joinInput" readonly value="${dto.email }"> 
      </li>
      
      <!-- <li>
        <div class="joinTitle">비밀번호</div>
        <input type="password" name="password" placeholder="비밀번호" class="joinInput">
      </li>
      <li>
        <div class="joinTitle">비밀번호 확인</div>
        <input type="password" name="password1" placeholder="비밀번호 확인" class="joinInput">
      </li> -->
      <li>
        <div class="joinTitle">이름</div>
        <input type="text" name="name" placeholder="이름" class="joinInput" readonly value="${dto.name }">
      </li>
      <li class="joinGenderAge">
        <div class="gender">
          <div class="joinTitle">성별</div>
          <div class="genderInput">
            <input type="text" value="${dto.gender }" name="gender" id="male" class="joinInput" readonly>
          </div>
        </div>
        <div class="age">
          <div class="joinTitle">나이*</div>
          <input type="number" name="age" min="10" max="99" class="joinInput"
						value="${dto.age }">
        </div>
      </li>
      <li>
        <div class="joinTitle">전화번호*</div>
        <input type="text" name="phone" placeholder="전화번호를 입력하세요" class="joinInput" value="${dto.phone }">
      </li>
      <li class="joinAddrLi">
        <div class="joinTitle">주소*</div>
        <div class="joinAddr">
          <input name="addr" type="button" id="member_post" value="주소찾기" onclick="findAddr()" >
          <input name="addr" id="member_addr" class="joinInput" value="${dto.addr }*">
      </div>
      </li>
      <li>
        <div class="joinTitle">닉네임</div>
        <input type="text" name="nickname" placeholder="닉네임을 입력하세요" class="joinInput" value="${dto.nickname }" readonly>
      </li>
      <li>
        <input type="submit" value="수정 완료" class="joinInput submit" >
      </li>
    </ul>
</form>

	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>