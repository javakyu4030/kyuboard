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
	<div id="login_form"> <!-- ????????? ??? -->



				<h1>Sign into KyuBoard</h1>
				<hr>
				<!-- <P>The time on the server is ${serverTime}.</P> 
				
				<p>
					<a href="board/list">????????? ??????</a>
				</p>

				<p>
					<a href="board/write">????????? ??????</a>
				</p> -->

				<!-- ?????? ?????? (?????????) -->
				<c:if test="${member == null}">
					<form role="form" method="post" autocomplete="off"
						action="/member/login">
						<!-- ????????? -->
						<p style="text-align:left; font-size:15px; color:#666">
							<label for="userId" id="id">User ID</label> 
						</p>
							<input type="text" placeholder="????????? ??????" id="userId" name="userId" />
							
						<!-- ???????????? -->	
						<p style="text-align:left; font-size:15px; color:#666">
							<label for="userPass" id="pass">Password</label> 
						</p>
							<input type="password" placeholder="???????????? ??????" id="userPass" name="userPass" />
						<p>
							<button type="submit" class="btn" >?????????</button>
						</p>
						<hr>
						<p>
							<a href="/member/register" class="join"> ????????????</a>
						</p>

					</form>
				</c:if>

				<c:if test="${msg == false}">
					<p style="color: #f00;">???????????? ??????????????????. <br>????????? ?????? ??????????????? ?????? <br>?????????????????????.</p>
				</c:if>

				<c:if test="${member != null}">
					<p>${member.userName}???!???????????????!</p>

					<a href="member/modify">???????????? ??????</a>, <a href="member/withdrawal">????????????</a>
					<br />
					<a href="member/logout">????????????</a>
				</c:if>


			</div>
	</div>
	</div>




	<!-- --------------------------------??????-------------------------------- -->
<!-- 
	<h1>Kyu??? ?????????</h1>
	<P>The time on the server is ${serverTime}.</P>

	<p>
		<a href="board/list">????????? ??????</a>
	</p>

	<p>
		<a href="board/write">????????? ??????</a>
	</p>

	-- ?????? ?????? (?????????) --
	<c:if test="${member == null}"> 
		<form role="form" method="post" autocomplete="off"
			action="/member/login">
			<p>
				<label for="userId">?????????</label> <input type="text" id="userId"
					name="userId" />
			</p>
			<p>
				<label for="userPass">????????????</label> <input type="password"
					id="userPass" name="userPass" />
			</p>
			<p>
				<button type="submit">?????????</button>
			</p>
			<p>
				<a href="/member/register">????????????</a>
			</p>

		</form>
	</c:if>
	
	<c:if test="${msg == false}">
		<p style="color:#f00;">???????????? ??????????????????. ????????? ?????? ??????????????? ?????? ?????????????????????.</p>
	</c:if>

	<c:if test="${member != null}">
		<p>${member.userName}???! ???????????????!</p>
		
		<a href="member/modify">???????????? ??????</a>, <a href="member/withdrawal">????????????</a><br />
		 <a href="member/logout">????????????</a>
	</c:if>
 -->
</body>
</html>
