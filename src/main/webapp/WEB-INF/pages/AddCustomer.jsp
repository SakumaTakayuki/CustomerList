<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="jp">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link
        rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    />
    <title>新規登録</title>
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

        .container-fluid {
            background-color: white;
            width: 900px;
            padding-top: 5px;
            padding-bottom: 5px;
        }

        .row {
            font-size: 18px;
            margin-bottom: 5px;
        }

        span {
            background-color: red;
            color: white;
            font-size: 15px;
            border: 1px solid black;
        }

        .textBox {
            width: 300px;
            height: 30px;
        }

        .select {
            width: 165px;
            height: 30px;
        }

        .textArea {
            width: 300px;
            height: 150px;
            font-size: 15px;
            resize: none;
        }

        .addButton {
            font-size: 18px;
            width: 90px;
            height: 30px;
        }

        .button {
            font-size: 18px;
            width: 90px;
            height: 30px;
        }

    </style>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js" type="text/javascript"></script>
</head>
<body>
    <div class="topBar">新規登録</div>
    <div class="parnentContainer">
        <div class="container-fluid">
        <div class="alert">${message}</div>
            <form action="AddProgram" method="post">
                <div class="row">
                    <div class="col-xs-1"></div>
                    <div class="col-xs-3">名前　<span>必須</span></div>
                    <div class="col-xs-8">
                        <input
                            type="text"
                            name="Name"
                            id="Name"
                            class="textBox"
                        />
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-1"></div>
                    <div class="col-xs-3">電話番号　<span>必須</span></div>
                    <div class="col-xs-8">
                        <input
                            type="text"
                            name="Tel"
                            id="Tel"
                            class="textBox"
                        />
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-1"></div>
                    <div class="col-xs-3">利用期間</div>
                    <div class="col-xs-8">
                        <select name="Duration" id="Duration" class="select">
                            <option value="0" selected></option>
                            <option value="1">半年未満</option>
                            <option value="2">１年未満</option>
                            <option value="3">１年半未満</option>
                            <option value="4">２年未満</option>
                            <option value="5">２年以上</option>
                            <option value="9">不明</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-1"></div>
                    <div class="col-xs-3">機種</div>
                    <div class="col-xs-8">
                        <select name="Type" id="Type" class="select">
                            <option value="0" selected></option>
                            <option value="1">スマホI</option>
                            <option value="2">スマホA</option>
                            <option value="3">ガラケー</option>
                            <option value="4">未所持</option>
                            <option value="9">不明</option>
                        </select>
                    </div>
                </div>
                <div class="row" class="select">
                    <div class="col-xs-1"></div>
                    <div class="col-xs-3">インターネット</div>
                    <div class="col-xs-8">
                        <select name="Net" id="Net" class="select">
                            <option value="0" selected></option>
                            <option value="1">インターネットD</option>
                            <option value="2">インターネットA</option>
                            <option value="3">インターネットS</option>
                            <option value="4">インターネットR</option>
                            <option value="5">その他</option>
                            <option value="6">未利用</option>
                            <option value="9">不明</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-1"></div>
                    <div class="col-xs-3">memo</div>
                    <div class="col-xs-8">
                        <textarea name="memo" class="textArea"></textarea>
                    </div>
                </div>
            <div class="buttons">
                <input type="submit" value="新規登録" class="addButton" style="float: left;">
            </form>
                <form action="Back" method="post">
                    <input type="submit" value="戻る" class="button" style="float: right;">
                </form>
            </div>
        </div>
    </div>
<script>
    $(".addButton").click(function() {
        if($("#Name").val() == ""){
            alert("名前を入力してください");
            return false;
        }
        if($("#Tel").val() == ""){
            alert("電話番号を入力してください");
            return false;
        }
    });
</script>
</body>
</html>