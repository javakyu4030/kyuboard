<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>KyuBoard</title>
</head>

<Style>
@import url('http://fonts.googleapis.com/earlyaccess/nanumgothic.css');
@font-face {font-family: 'Noto Sans KR';font-style: normal;font-weight: 100;src: url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Thin.woff2) format('woff2'),url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Thin.woff) format('woff'),url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Thin.otf) format('opentype');}
@font-face {font-family: 'Noto Sans KR';font-style: normal;font-weight: 300;src: url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Light.woff2) format('woff2'),url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Light.woff) format('woff'),url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Light.otf) format('opentype');} 
@font-face {font-family: 'Noto Sans KR';font-style: normal;font-weight: 400;src: url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Regular.woff2) format('woff2'),url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Regular.woff) format('woff'),url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Regular.otf) format('opentype');} 
@font-face {font-family: 'Noto Sans KR';font-style: normal;font-weight: 500;src: url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Medium.woff2) format('woff2'),url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Medium.woff) format('woff'),url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Medium.otf) format('opentype');} 
@font-face {font-family: 'Noto Sans KR';font-style: normal;font-weight: 700;src: url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Bold.woff2) format('woff2'),url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Bold.woff) format('woff'),url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Bold.otf) format('opentype');} 
@font-face {font-family: 'Noto Sans KR';font-style: normal;font-weight: 900;src: url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Black.woff2) format('woff2'),url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Black.woff) format('woff'),url(//fonts.gstatic.com/ea/notosanskr/v2/NotoSansKR-Black.otf) format('opentype');}
	
	
	body{
		margin:0 auto;
	
	/* body, table, div, p, span{font-family:'Nanum Gothic';}*/
		body, table, div, p, span{font-family:'Noto Sans KR';}
	
	}
	
	a{
		text-decoration: none;
		color:#333;
	}
	
	#con{
		width:100%;
		height: 100vh;
		background-color:#382B47;
		background-image: url('https://cdn.pixabay.com/photo/2022/01/31/15/18/coffee-6984075_960_720.jpg');
		background-position: center center;
        background-repeat: no-repeat;
        background-size:cover;
        padding:0;
	}
	
	#login{
		 border-radius: 60px;
         padding:100px;
         text-align: center;
         position: absolute;
         top:50%;
         left:50%;
         transform: translate(-50%, -50%);
         opacity:0.9;
	}
	#login_form{
		width:150%;
		border-radius:10px;
		padding:30px;
		background: #fff;
		text-align:center;
        position: absolute;
        top:50%;
        left:50%;
        transform: translate(-50%, -50%);
        
	}
	
	#id{
		text-align: center;
		font-weight: 100px; 
		font-size:20px;
		color:#666
	}
	#pass{
		text-align: center;
		font-weight: 100px; 
		font-size:20px;
		color:#666
	}
	#userId{
		width: 300px; 
		height: 30px;
		padding-left:10px;
		background-color:#f4f4f4;
		border:none;
		border-radius:1px;
		font-style:italic;
	}
	#userPass{
		width: 300px; 
		height: 30px;
		padding-left:10px;
		background-color:#f4f4f4;
		border:none;
		border-radius:1px;
		font-style:italic;
	}
	.size{
		width:300px;
		height:30px;
		padding-left:10px;
		background-color:#fff;
	}
	.btn{
		width:310px;
		height:40px;
		font-size:15px;
		background-color:#BEA6A0;
		color:#fff;
		border:none;
		cursor:pointer;
		font-family: Noto Sans KR;
		
	}
	.join{
		width:610px;
		height:40px;
		font-size:15px;
		background-color:none;
		border:none;
		cursor:pointer;
		font-family: Noto Sans KR;
	}


</Style>


<body>
	<div id="con">
	<div id="login">
	<div id="login_form"> <!-- 로그인 폼 -->



				<h1>Sign into KyuBoard</h1>
				<hr>
				<!-- <P>The time on the server is ${serverTime}.</P> 
				
				<p>
					<a href="board/list">게시물 목록</a>
				</p>

				<p>
					<a href="board/write">게시물 작성</a>
				</p> -->

				<!-- 내용 추가 (로그인) -->
				<c:if test="${member == null}">
					<form role="form" method="post" autocomplete="off"
						action="/member/login">
						<!-- 아이디 -->
						<p style="text-align:left; font-size:15px; color:#666">
							<label for="userId" id="id">User ID</label> 
						</p>
							<input type="text" placeholder="아이디 입력" id="userId" name="userId" />
							
						<!-- 비밀번호 -->	
						<p style="text-align:left; font-size:15px; color:#666">
							<label for="userPass" id="pass">Password</label> 
						</p>
							<input type="password" placeholder="비밀번호 입력" id="userPass" name="userPass" />
						<p>
							<button type="submit" class="btn" >로그인</button>
						</p>
						<hr>
						<p>
							<a href="/member/register" class="join"> 회원가입</a>
						</p>

					</form>
				</c:if>

				<c:if test="${msg == false}">
					<p style="color: #f00;">로그인에 실패했습니다. <br>아이디 또는 패스워드를 다시 <br>입력해주십시오.</p>
				</c:if>

				<c:if test="${member != null}">
					<p>${member.userName}님!환영합니다!</p>

					<a href="member/modify">회원정보 수정</a>, <a href="member/withdrawal">회원탈퇴</a>
					<br />
					<a href="member/logout">로그아웃</a>
				</c:if>


			</div>
	</div>
	</div>




	<!-- --------------------------------원본-------------------------------- -->
<!-- 
	<h1>Kyu의 게시판</h1>
	<P>The time on the server is ${serverTime}.</P>

	<p>
		<a href="board/list">게시물 목록</a>
	</p>

	<p>
		<a href="board/write">게시물 작성</a>
	</p>

	-- 내용 추가 (로그인) --
	<c:if test="${member == null}"> 
		<form role="form" method="post" autocomplete="off"
			action="/member/login">
			<p>
				<label for="userId">아이디</label> <input type="text" id="userId"
					name="userId" />
			</p>
			<p>
				<label for="userPass">패스워드</label> <input type="password"
					id="userPass" name="userPass" />
			</p>
			<p>
				<button type="submit">로그인</button>
			</p>
			<p>
				<a href="/member/register">회원가입</a>
			</p>

		</form>
	</c:if>
	
	<c:if test="${msg == false}">
		<p style="color:#f00;">로그인에 실패했습니다. 아이디 또는 패스워드를 다시 입력해주십시오.</p>
	</c:if>

	<c:if test="${member != null}">
		<p>${member.userName}님! 환영합니다!</p>
		
		<a href="member/modify">회원정보 수정</a>, <a href="member/withdrawal">회원탈퇴</a><br />
		 <a href="member/logout">로그아웃</a>
	</c:if>
 -->
</body>
</html>
