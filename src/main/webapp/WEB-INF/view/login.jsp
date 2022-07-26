<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Boyaki575</title>
</head>
<body>
	<h1>575でぼやこう！</h1>
	<form action="" method="post">
		<p>
			名前:<input type="text" name="login_id" value="${loginId}">
		</p>
		<c:if test="${not empty loginIdErrorMessage}">
			<p>
				<c:out value="${loginIdErrorMessage}" />
			</p>
		</c:if>
		<p>
			パスワード<input type="password" name="login_pass">
		</p>
		<c:if test="${not empty loginPassErrorMessage}">
			<p>
				<c:out value="${loginPassErrorMessage}" />
			</p>
		</c:if>
		<input type="submit" value="ログイン">
		<c:if test="${not empty errorMessage}">
			<p>
				<c:out value="${errorMessage}" />
			</p>
		</c:if>
	</form>
</body>
</html>