<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
<title>Boyaki575</title>
</head>
<body>
	よしなしごとを５７５でぼやこう！

	<form action="" method="post">
		<p>
			上の句: <input type="text" name="upper" value="${upper}">
		</p>
		<c:if test="${not empty upperErrorMessage}">
			<p>
				<c:out value="${upperErrorMessage}" />
			</p>
		</c:if>

		<p>
			中の句: <input type="text" name="middle" value="${middle}">
		</p>
		<c:if test="${not empty middleErrorMessage}">
			<p>
				<c:out value="${middleErrorMessage}" />
			</p>
		</c:if>
		<p>
			下の句: <input type="text" name="lower" value="${lower}">
		</p>
		<c:if test="${not empty lowerErrorMessage}">
			<p>
				<c:out value="${lowerErrorMessage}" />
			</p>
		</c:if>
		<p>
			匿名希望
			<input type="radio" name="nameIsSecret" value="true" >はい
			<input type="radio" name="nameIsSecret" value="false" checked>いいえ
		</p>
		<button type="submit" name="button" value="write">ぼやく</button>
		<button type="submit" name="button" value="random">ランダム</button>
	</form>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>