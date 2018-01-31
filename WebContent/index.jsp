<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" type="text/css" href="css/style.css" >
<title>PHANTOM PRODUCTION</title>
</head>
<body>
	<div id="header">
		<a href="index.jsp"><img  src="./image/phanp.png"></a>
	<ul>

	<s:if test="#session.loginUser.accountId != length()">
	<s:iterator value="#session.loginUser">
	<li>こんにちは、<a href='<s:url action="MyPageAction"/>'><s:property value="userName"/></a>さん</li>
	</s:iterator>
	</s:if>


	<s:if test="#session.loginUser == length()">
	<li><a href='<s:url action="LoginFormAction"/>'>ログイン</a></li>
	</s:if>

			<s:if test="#session.loginUser.accountId == length()">
			<li><a href='<s:url action="LoginFormAction"/>'>ログイン</a></li>
			</s:if>

	<s:if test="#session.loginUser.accountId != length()">
	<li><a href='<s:url action="LogoutAction"/>'>ログアウト</a></li>
	</s:if>

	<s:if test="#session.loginUser == length()">
	<li><a href='<s:url action="UserCreateAction"/>'>新規登録</a></li>
	</s:if>
			<s:if test="#session.loginUser.accountId == length()">
			<li><a href='<s:url action="UserCreateAction"/>'>新規登録</a></li>
			</s:if>

	<li><a href='<s:url action="HelpAction"/>'>ヘルプ</a></li>

	</ul>

	</div>

	<div id="main">

	<div id="menu">
		<div class="menu">
		<h1>シリーズタイトルから探す</h1>
		<a href='<s:url action="SearchAction"/>'>OrcinusBlue</a><br>
		<a href='<s:url action="SearchAction"/>'>ScarletCode</a><br>
		<a href='<s:url action="SearchAction"/>'>MaximumFear</a>
		</div>

		<div class="menu">
		<h1>ジャンルから探す</h1>
		<a href='<s:url action="SearchAction"/>'>Book</a><br>
		<a href='<s:url action="SearchAction"/>'>Game</a><br>
		<a href='<s:url action="SearchAction"/>'>Sound</a>
		</div>

		<div class="menu">
		<h1></h1>
		お探しの作品名を入力<br>してください

		<div align="center">
		<p>
		<s:form action="SearchAction">
		<s:textfield name="search"/>
		<s:submit value="検索"/>
		</s:form>
		</p>
		</div>
		</div>

<div class="menu">
<p>ログインしてるユーザー情報</p>
		<s:iterator value="#session.loginUser">
		<s:property value="userNumber"/><br>
		<s:property value="accountId"/><br>
		<s:property value="userName"/><br>
		<s:property value="userPassword"/><br>
		<s:property value="userMail"/><br>
		</s:iterator>

</div>

	</div>


	<div id="content">

	<div id="pick">

	<img src="./image/ao.png" >

	</div>
	<img alt="" src="./image/bor.png">
	<img alt="" src="./image/bor.png">
	</div>

	</div>

<div id="sita">
<img alt="" src="./image/bor.png">
<div class="right">
		<ul>
		<li><h1>ご利用方法</h1></li>
		<li><a href='<s:url action="HelpAction" value="guide"/>'>ご利用ガイド</a></li>
		<li><a href='<s:url action="HelpAction" value="guide"/>'>お支払方法について</a></li>
		<li><a href='<s:url action="HelpAction" value="deli"/>'>配送・送料について</a></li>
		<li><a href='<s:url action="HelpAction" value="mail"/>'>メールについて</a><li>
		</ul>

		<ul>
		<li><h1>お問い合わせ</h1></li>
		<li><a href='<s:url action="InquiryAction"/>'>こちらから</a></li>
		</ul>
</div>
</div>

	<div id="footer">
	Copyright &copy PHANTOM PRODUCTION STORE All rights
	</div>

</body>
</html>