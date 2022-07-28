<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	<a href="boyakiWrite" class="btn btn-primary">ぼやく</a>
	<a href="logout" class="btn btn-secondary">ログアウト</a>

	<c:forEach items="${boyakiList}" var="boyaki">
		<table class="table table table-bordered table-striped">
			<tr>
				<th>作者</th>
				<td><c:choose>
						<c:when test="${boyaki.isSecret == false }">
							<c:out value="${boyaki.userName}" />
						</c:when>
						<c:otherwise>
				詠み人知らず
				</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<th>日時</th>
				<td><fmt:formatDate value="${boyaki.date}"
						pattern="y年MM月dd日 HH時mm分" /></td>
			</tr>
			<tr>
				<th>ぼやき</th>
				<td><c:out value="${boyaki.upper}" /><br> <c:out
						value="${boyaki.middle}" /><br> <c:out
						value="${boyaki.lower}" /></td>
			</tr>
			<tr>
				<th>いいね！</th>
				<td><c:out value="${boyaki.goodsCount}" />
					<form action="" method="post">
						<c:choose>
							<c:when test="${goodIsPossible == true}">
								<button type="submit" class="btn btn-success" name="goodId" value="${boyaki.id}">いいね！</button>
							</c:when>
							<c:otherwise>
								<button type="submit" class="btn btn-success" name="goodId" value="${boyaki.id}"
									disabled="disabled">いいね！</button>
							</c:otherwise>
						</c:choose>
					</form></td>
			</tr>
		</table>
		<br>
	</c:forEach>


	<script src="bootstrap.bundle.min.js"></script>
</body>
</html>