<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::deco::cafe등록</title>
<%@ include file="../top.jsp"%>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/cafeInsert.css">
</head>
<body>
	<section>
		
		<!-- <form  method="post" action="cafeInsertAction.deco" enctype="multipart/form-data" > -->
		<article>
			<div class="container" role="main">
				<div class="logo-wrap">
					<h1 class="logo_txt">CAFE</h1>
				</div>
				<div class="form_wrap">
					<form name="form" id="form" role="form" method="post"
						action="cafeInsertAction.deco" enctype="multipart/form-data">
						<%-- ${pageContext.request.contextPath}/board/saveBoard --%>
						<div class="form-control-wrap">
							<label for="location">지역*</label> <input type="text"
								class="form-control" name="location" id="title"
								placeholder="지역을 입력하세요">
						</div>
						<div class="form-control-wrap">
							<label for="name">상호*</label> <input type="text"
								class="form-control" name="name" id="name"
								placeholder="상호명을 입력하세요">
						</div>
						<div class="form-control-wrap">
							<label for="grade">평점*</label> <input type="number"
								class="form-control" name="grade" id="grade" value="5" max="5"
								min="1">
						</div>
						<div class="form-control-wrap">
							<label for="menu1">메뉴*</label>
							<div class="menu_container">
								<div class="menu_123">
									<div class="menu_el">
										메뉴1<input type="text" class="form-control" name="menu1"
											id="menu1" placeholder="ex) 아메리카노">
									</div>
									<div class="menu_el">
										가격1<input type="text" class="form-control" name="price1"
											id="price1" placeholder="ex) 3,000">원
									</div>
								</div>
								<div class="menu_123">
									<div class="menu_el">
										메뉴2<input type="text" class="form-control" name="menu2"
											id="menu2" placeholder="">
									</div>
									<div class="menu_el">
										가격2<input type="text" class="form-control" name="price2"
											id="price2" placeholder="">원
									</div>
								</div>
								<div class="menu_123">
									<div class="menu_el">
										메뉴3<input type="text" class="form-control" name="menu3"
											id="menu3" placeholder="">
									</div>
									<div class="menu_el">
										가격3<input type="text" class="form-control" name="price3"
											id="price3" placeholder="">원
									</div>
								</div>
							</div>
						</div>
						<div class="form-control-wrap">
							<label for="content">내용*</label>
							<textarea class="form-control" rows="5" name="content"
								id="content" placeholder="내용을 입력해 주세요"></textarea>
						</div>
						<div class="form-control-wrap">
							<label for="openTime" class="ft-tit">영업시간*</label>
							<div class="form-time-wrap">
								<span class="ft-tit">Open</span> <input type="time"
									class="form-time" name="opentime" id="openTime"> <span
									class="ft-tit">Close</span> <input type="time"
									class="form-time" name="closetime" id="closeTime">
							</div>
						</div>
						<div class="form-control-wrap">
							<div class="form-img">
								<div>
									<div for="" class="pre-thumbnail">외부 사진*</div>
									<label for="file-upload" class="file-upload">업로드</label>
									<div id="image_container"></div>
									<input type="file" id="file-upload" accept="image/*"
										name="outpic">
								</div>
								<div id="view-thumbnail" class="thubmbail"></div>
							</div>
						</div>
						<div class="form-control-wrap">
							<div class="form-img">
								<div>
									<div for="" class="pre-thumbnail">내부 사진*</div>
									<label for="file-upload2" class="file-upload">업로드</label> <input
										type="file" id="file-upload2" accept="image/*" name="intpic">
								</div>
								<div id="view-thumbnail2" class="thubmbail"></div>
							</div>
						</div>
						<div class="form-control-wrap">
							<label for="member_post">주소*</label> <input name="addr"
								type="button" id="member_post" value="주소 찾기" class="member_post"
								onclick="findAddr()"> <input name="addr"
								id="member_addr" class="joinInput">
							<!-- <input type="text" class="form-control" name="tag" id="tag" placeholder=""> -->
						</div>
						<div class="form-control-wrap">
							<label for="phone">전화번호*</label> <input type="text"
								class="form-control" name="phone" id="phone"
								placeholder="010XXXXXXXX">
						</div>
						<div class="form-btn">
							<input type="submit" value="등록 완료" class="submit">
						</div>
					</form>
				</div>

			</div>
		</article>
		<!-- </form> -->


		<!-- <table>
		<tr>
					<td><label>카페 이름</label></td>
					 required 필수 입력  , readonly : 읽기만.
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
					<td><label>외부 사진 등록</label></td>
					<td><input type="file" name="outpic" accept="image/*" placeholder="외부 이미지 파일을 선택해주세요"
					onchange="setThumbnail(event);"></td>
					<td> <div id="image_container"></div></td>
				</tr>
				<tr>
					<td><label>내부 사진 등록</label></td>
					<td><input type="file" name="inpic" accept="image/*" placeholder="내부 이미지 파일을 선택해주세요"
					onchange="setThumbnail(event);"></td>
					<td><div id="image_container"></div></td>
				</tr>
				
				<tr> 
				<td> 
					<input type="submit" value="저장" class="">
					<input type="reset" value="다시쓰기" class="">
					<input type="button" value="목록" onclick="location.href='list.deco'" class="">
				 </td>
				</tr>
				
				</table>
				
				 -->

	</section>
	<script type="text/javascript">
		function setThumbnail(event) {
			var reader = new FileReader();
			reader.onload = function(event) {
				var img = document.createElement("img");
				img.setAttribute("src", event.target.result);
				document.querySelector("div#image_container").appendChild(img);
			};
			reader.readAsDataURL(event.target.files[0]);
		}
	</script>

	<script src="./upload.js"></script>
</body>
<%@ include file="../bottom.jsp"%>
</html>