<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Boyaki575</title>
</head>
<body>
<h1>ユーザー登録</h1>

<form action="" method="post">
<p>名前: <input type="text" name="name"></p>
          <c:if test="${not empty nameErrorMessage}">
            <p><c:out value="${nameErrorMessage}" /></p>
        </c:if>
<p>ユーザーID: <input type="text" name="loginId"></p>
          <c:if test="${not empty loginIdErrorMessage}">
            <p><c:out value="${loginIdErrorMessage}" /></p>
        </c:if>
<p>パスワード: <input type="password" name="loginPass"></p>
          <c:if test="${not empty loginPassErrorMessage}">
            <p><c:out value="${loginPassErrorMessage}" /></p>
        </c:if>
<p><input type="submit" value="登録"></p>
</form>
<a href="login">ログインページに戻る</a>
</body>
</html>