<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" type="text/css" href="css/style.css" >
<link rel="stylesheet" type="text/css" href="css/jquery.bxslider.css" >
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

	<div id="pan">
	Index
	</div>

	</div>

	<div id="main">


<div id="menu">
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

	</div>


	<div id="content">
マイページ

	<s:if test="myPageList == null">
	<p>購入情報はありません</p>
	</s:if>

	<s:elseif test="message == null">
	<p>購入情報は以下になります</p>
<table>
		<s:iterator value="myPageList">
		<td><s:property value="itemName"/></td>
		<td><img src='<s:property value="itemImage"/>'/></td>
		<td><s:property value="totalPrice"/></td>
		<td><s:property value="totalCount"/></td>
		<td><s:property value="payment"/></td>
		</s:iterator>
</table>
	<s:form action="MyPageAction">
		<input type="hidden" name="deleteFlg" value="1">
		<s:submit value="削除" method="delete"/>
	</s:form>
	</s:elseif>
	<s:if test="message != null">
	<p><s:property value="message"/></p>
	</s:if>

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