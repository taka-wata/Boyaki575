<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="bootstrap.min.css" rel="stylesheet">
<title>Boyaki575</title>

</head>
<body>
	<a href="boyakiWrite">ぼやく</a>
	<a href="logout">ログアウト</a>

	<c:forEach items="${boyakiList}" var="boyaki">
		<table border="1">
			<tr>
				<th>作者</th>
				<td>
				<c:choose>
				<c:when test="${boyaki.isSecret == false }">
				<c:out value="${boyaki.userName}" />
				</c:when>
				<c:otherwise>
				詠み人知らず
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<th>日時</th>
				<td><c:out value="${boyaki.date }" /></td>
			</tr>
			<tr>
				<th>ぼやき</th>
				<td><c:out value="${boyaki.upper}" /><br>
				<c:out value="${boyaki.middle}" /><br>
				<c:out value="${boyaki.lower}" /></td>
			</tr>
			<tr>
				<th>いいね！</th>
				<td><c:out value="${boyaki.goodsCount}" />
						<form action="" method="post">
						<c:choose>
							<c:when test="${goodIsPossible == true}">
								<button type="submit" name="goodId" value="${boyaki.id}">いいね！</button>
							</c:when>
							<c:otherwise>
								<button type="submit" name="goodId" value="${boyaki.id}"
									disabled="disabled">いいね！</button>
							</c:otherwise>
					</c:choose>
					</form>
					</td>
			</tr>
		</table>
		<br>
	</c:forEach>
	
	
<script src="bootstrap.bundle.min.js"></script>
</body>
</html>