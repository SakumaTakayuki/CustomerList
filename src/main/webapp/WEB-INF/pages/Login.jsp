<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="jp">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログイン</title>
    <style>
        body {
            background-color: #dcdcdc;
        }

        .topBar {
            background-color: white;
            font-size: 25px;
            font-weight: bold;
            text-align: center;
            margin: 5px 0 5px 0;
        }

        .alert {
            color: red;
            font-size: 18px;
            text-align: center;
            margin-bottom: 5px;
        }

        .login {
            width: 480px;
            text-align: center;
            background-color: white;
            margin: 0 auto;
            padding-top: 5px;
        }

        .textBox {
            width: 300px;
            height: 30px;
            margin-bottom: 5px;
        }

        .button {
            font-size: 18px;
            width: 90px;
            height: 30px;
            margin-bottom: 5px;
        }

        .button:hover {
            cursor: pointer;
        }

    </style>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js" type="text/javascript"></script>
</head>
<body>
    <div class="topBar">顧客管理システム</div>
    <div class="container">
        <div class="login">
        	<div class="alert">${message}</div>
            <form action="Login" method="post">
                <input type="text" name="UserId" id="UserId" class="textBox" placeholder="ユーザーID">
                <input type="password" name="Password" id="Password" class="textBox" placeholder="パスワード"><br>
                <input type="submit" class="button" value="ログイン">
            </form>
            <a href="ChangePass">パスワード変更</a>
        </div>
    </div>
<script>
    $(".button").click(function() {
        if($("#UserId").val() == "") {
            alert("ユーザーIDを入力してください");
            return false;
        }
        if($("#Password").val() == "") {
            alert("パスワードを入力してください");
            return false;
        }
    });
</script>
</body>
</html>