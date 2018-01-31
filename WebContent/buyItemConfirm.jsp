<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/style.css" >
<link rel="stylesheet" type="text/css" href="css/jquery.bxslider.css" >
<title>PHANTOM PRODUCTION</title>

	<script type="text/javascript">
		function submitAction(url) {
			$('form').attr('action',url);
			$('form').submit();
		}
	</script>

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
	</div>


		<s:form action="BuyItemAction">
		<table>

		<tr>
		<td><s:property value="session.buyItem_name"/></td>
		</tr>
		<tr>
		<td><s:property value="session.buyItem_image"/></td>
		</tr>
			<tr>
			<td><s:property value="session.total_price"/></td>
			</tr>
				<tr>
				<td>購入個数</td>
				<td>
				<s:property value="session.count"/>
				</td>
				</tr>
			<tr>
			<td>
			支払い方法
			</td>
	<td><s:property value="session.pay"/></td>
			</tr>

					<tr>
					<td><input type="button" value="戻る"
					onclick="submitAction('HomeAction')"/></td>
					<td><input type="button" value="完了"
					onclick="submitAction('BuyItemConfirmAction')"></td>
				</tr>

		</table>
			<s:param name="itemName" value="%{itemName}"/>
			<s:param name="itemType" value="%{itemType}"/>
			<s:param name="itemPrice" value="%{itemPrice}"/>
			<s:param name="itemNumber" value="%{itemNumber}"/>
			<img src='<s:property value="itemImage"/>'/><br>

					<s:hidden name="itemImage" value="%{itemImage}"/>
		<s:hidden name="itemName" value="%{itemName}"/>
		<s:hidden name="itemType" value="%{itemType}"/>
		<s:hidden name="itemPrice" value="%{itemPrice}"/>
		<s:hidden name="itemNumber" value="%{itemNumber}"/>
		</s:form>



	<div id="content">
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