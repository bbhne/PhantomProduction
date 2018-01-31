<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/Style.css" >
	<link rel="stylesheet" type="text/css" href="css/List.css" >
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
	</div>

	</div>

	<div id="main">


		<div id="content">
		<div align="center">

	<table>
	<s:iterator value="searchList">
	<td>
	<div class="ribbon2"></div>
<s:form action="BuyItemDetailAction">
		<s:property value="itemNumber"/>
		<br>
		<a href='<s:url action="BuyItemDetailAction">
			<s:param name="itemName" value="%{itemName}"/>
			<s:param name="itemType" value="%{itemType}"/>
			<s:param name="itemPrice" value="%{itemPrice}"/>
			<s:param name="itemNumber" value="%{itemNumber}"/>
			<s:param name="itemImage" value="%{itemImage}"/>
			</s:url>'><img src='<s:property value="%{itemImage}"/>'/></a><br>
		<p><s:property value="itemName"/></p>
		<s:property value="itemType"/><br>
		<s:property value="itemPrice"/><br>

	</s:form>
	</td>
	</s:iterator>
	</table>
		</div>
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