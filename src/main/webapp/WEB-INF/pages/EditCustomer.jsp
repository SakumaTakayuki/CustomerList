<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="jp">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link
        rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    />
    <title>編集</title>
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

        .updateButton {
            font-size: 18px;
            width: 90px;
            height: 30px;
        }

        .button {
            font-size: 18px;
            width: 90px;
            height: 30px;
        }

        .deleteButton {
            font-size: 18px;
            width: 90px;
            height: 30px;
        }


    </style>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
</head>
<body>
    <div class="topBar">編集</div>
    <div class="parnentContainer">
        <div class="container-fluid">
            <div class="alert">${message}</div>
            <form action="UpdateCustomer" method="post">
                <div class="row">
                    <div class="col-xs-1"></div>
                    <div class="col-xs-3">名前　<span>必須</span></div>
                    <div class="col-xs-8">
                        <input
                            type="text"
                            name="Name"
                            class="textBox"
                            value="${Name}"
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
                            class="textBox"
                            value="${Tel}"
                        />
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-1"></div>
                    <div class="col-xs-3">利用期間</div>
                    <div class="col-xs-8">
                        <select name="Duration" class="select">
                            <option value="0" <c:if test = "${Duration == 0}">selected</c:if>></option>
                            <option value="1" <c:if test = "${Duration == 1}">selected</c:if>>半年未満</option>
                            <option value="2" <c:if test = "${Duration == 2}">selected</c:if>>１年未満</option>
                            <option value="3" <c:if test = "${Duration == 3}">selected</c:if>>１年半未満</option>
                            <option value="4" <c:if test = "${Duration == 4}">selected</c:if>>２年未満</option>
                            <option value="5" <c:if test = "${Duration == 5}">selected</c:if>>２年以上</option>
                            <option value="9" <c:if test = "${Duration == 9}">selected</c:if>>不明</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-1"></div>
                    <div class="col-xs-3">機種</div>
                    <div class="col-xs-8">
                        <select name="Type" class="select">
                            <option value="0" <c:if test = "${Type == 0}">selected</c:if>></option>
                            <option value="1" <c:if test = "${Type == 1}">selected</c:if>>スマホI</option>
                            <option value="2" <c:if test = "${Type == 2}">selected</c:if>>スマホA</option>
                            <option value="3" <c:if test = "${Type == 3}">selected</c:if>>ガラケー</option>
                            <option value="4" <c:if test = "${Type == 4}">selected</c:if>>未所持</option>
                            <option value="9" <c:if test = "${Type == 9}">selected</c:if>>不明</option>
                        </select>
                    </div>
                </div>
                <div class="row" class="select">
                    <div class="col-xs-1"></div>
                    <div class="col-xs-3">インターネット</div>
                    <div class="col-xs-8">
                        <select name="Net" class="select">
                            <option value="0" <c:if test = "${Net == 0}">selected</c:if>></option>
                            <option value="1" <c:if test = "${Net == 1}">selected</c:if>>インターネットD</option>
                            <option value="2" <c:if test = "${Net == 2}">selected</c:if>>インターネットA</option>
                            <option value="3" <c:if test = "${Net == 3}">selected</c:if>>インターネットS</option>
                            <option value="4" <c:if test = "${Net == 4}">selected</c:if>>インターネットR</option>
                            <option value="5" <c:if test = "${Net == 5}">selected</c:if>>その他</option>
                            <option value="6" <c:if test = "${Net == 6}">selected</c:if>>未利用</option>
                            <option value="9" <c:if test = "${Net == 9}">selected</c:if>>不明</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-1"></div>
                    <div class="col-xs-3">memo</div>
                    <div class="col-xs-8">
                        <textarea name="Memo" class="textArea">${Memo}</textarea>
                    </div>
                </div>
            <div class="buttons">
            	<input type="hidden" name="CustomerId" value="${CustomerId}">
                <input type="submit" value="更新" class="updateButton" style="float: left;">
            </form>
                <form action="Back" method="post">
                    <input type="submit" value="戻る" class="button" style="float: right;">
                </form>
                <form action="DeleteCustomer" method="post">
                	<input type="hidden" name="CustomerId" value="${CustomerId}">
                    <input type="submit" value="削除" class="deleteButton" style="margin-left: 5px;">
                </form>
            </div>
        </div>
    </div>
<script>
    $(".updateButton").click(function(){
        if(window.confirm("更新していいですか？")) {
            return true;
        } else {
            return false;
        }
    });

    $(".deleteButton").click(function(){
        if(window.confirm("削除していいですか？")) {
            return true;
        } else {
            return false;
        }
    });
</script>
</body>
</html>