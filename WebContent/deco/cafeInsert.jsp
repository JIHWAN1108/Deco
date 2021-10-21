<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 업로드 view</title>
</head>
<body>
		<h3>카페 추천지 등록</h3>
		<form  method="post" action="cafeInsertAction.deco" >
		<table>
		<tr>
					<td><label>카페 이름</label></td>
					<!--  required 필수 입력  , readonly : 읽기만.-->
					<td><input type="text" name="name" placeholder="카페 이름(필수)"
						required></td>
				</tr>
				<tr>
					<td><label>카페 주소</label></td>
					<td><input type="text" name="addr" placeholder="주소 입력"></td>
				</tr>
				<tr> 
				 <td> <label>카페 지역명</label> </td>
				 <td> <input type ="text" name="location"></td>
				</tr>
				<tr>
					<td><label>카페 메뉴</label></td>
					<td><textarea rows="5" cols="50" placeholder ="메뉴를 작성해주세요"
 					class="input" name="menu"required></textarea></td>
				</tr>
				<tr> 
					<td><label>카페 평점</label> </td>
					<td> <input type ="number" name="grade" min ="1" max="5"> </td>
				
				</tr>
				<tr>
					<td><label>카페 전화번호</label></td>
					<td><input type="text" name="phone" placeholder="전화번호 입력"></td>
				</tr>
				<tr>
					<td><label>카페 OPEN 시간</label></td>
					<td><input type="time" name="opentime" placeholder="영업시간 입력"></td>
				</tr>
				<tr>
					<td><label>카페 CLOSE 시간</label></td>
					<td><input type="time" name="closetime" placeholder="영업시간 입력"></td>
				</tr>
				<tr>
					<td><label>카페 설명</label></td>
					<td><textarea rows="3" cols="80" placeholder ="내용을 작성해 주세요"
 					class="input"  name ="content" required></textarea></td>
				</tr>
				<tr>
					<td><label>사진 등록</label></td>
					<td><input type="file" name="pic" accept="image/*" placeholder="이미지 파일을 선택해주세요"></td>
				</tr>
				
				<tr> 
				<td> 
					<input type="submit" value="저장" class="">
					<input type="reset" value="다시쓰기" class="">
					<input type="button" value="목록" onclick="location.href='list.deco'" class="">
				 </td>
				</tr>
				
				</table>
				
				

</form>
				
</body>
</html>