<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Boyaki575</title>
</head>
<body>
    よしなしごとを５７５でぼやこう！

    <form action="boyakiDone.html" method="post">
        <p>上の句: <input type="text"></p>
        <p>中の句: <input type="text"></p>
        <p>下の句: <input type="text"></p>
        <p><input type="checkbox">匿名希望</p>
        <input type="submit" value="ぼやく">
        <input type="reset" value="クリア">
    </form>
</body>
</html>