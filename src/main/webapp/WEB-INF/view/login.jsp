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
	<header>
		<div class="container">
			<nav class="navbar navbar-dark" style="background-color:green;">
				<!-- Navbar content -->
				<div class="container-fluid">
					<span class="navbar-brand">Boyaki 575</span>
				</div>
			</nav>
		</div>
	</header>
    <form method="post" class="align-items-center">
        <div class="row mb-3">
          <label class="col-sm-2 col-form-label">ユーザー名</label>
          <div class="col-5 mb-3">
            <input type="text" class="form-control" name="loginId">
          </div>
          <c:if test="${not empty loginIdErrorMessage}">
            <div class="alert alert-warning" role="alert">
                <c:out value="${loginIdErrorMessage}" />
              </div>
        </c:if>
        </div>
        <div class="row mb-3">
          <label class="col-sm-2 col-form-label">パスワード</label>
          <div class="col-5 mb-3">
            <input type="password" class="form-control" name="loginPass">
          </div>
          <c:if test="${not empty loginPassErrorMessage}">
            <div class="alert alert-warning" role="alert">
                <c:out value="${loginPassErrorMessage}" />
              </div>
        </c:if>
        </div>
        <button type="submit" class="btn btn-primary">ログイン</button>
      </form>
        <a href="userAdd" class="btn btn-success">新規登録</a>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>

</html>