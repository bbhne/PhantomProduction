<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/Style.css" >
	<link rel="stylesheet" type="text/css" href="css/formStyle.css" >
<link rel="stylesheet" type="text/css" href="css/jquery.bxslider.css" >
<title>PHANTOM PRODUCTION</title>
</head>
<body>
	<div id="header">
		<a href="index.jsp"><img  src="./image/phanp.png"></a>
	<ul>

	<s:if test="#session.loginUser.accountId != length()">
	<s:iterator value="#session.loginUser">
	<li>こんにちは、<a href='<s:url action="MyPageAction"/>'><s:property value="userName"/></a>さん(zahura)</li>
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
	管理者画面
	</div>

	</div>

	<div id="main">


		<div id="content">
		<div align="center">

	<table>
	<s:iterator value="searchList">
	<td>
	<div class="ribbon2"></div>
		<s:property value="itemNumber"/><br>
		<a href='<s:url action="GoBuyItemAction"/>'><img src='<s:property value="itemImage"/>'/></a><br>
		<p><s:property value="itemName"/></p>
		<s:property value="itemType"/><br>
		<s:property value="itemPrice"/><br>

	</td>
	</s:iterator>
	</table>
		</div>
		</div>
<div id="content">

<div align="center">
		<p>問い合わせ一覧</p>




			<table>
				<tr>
				<th>名前</th>
				<th>種類</th>
				<th>内容</th>

				</tr>
				<s:iterator value="inquiryList">

					<tr>
					<td><s:property value="name"/></td>
					<td><s:property value="qtype"/></td>
					<td><s:property value="body"/></td>
					</tr>
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