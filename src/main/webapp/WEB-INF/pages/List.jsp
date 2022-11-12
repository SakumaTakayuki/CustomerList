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
    <title>顧客一覧</title>
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

        .textBox {
            width: 300px;
            height: 30px;
        }

        .select {
            width: 165px;
            height: 30px;
        }

        .button {
            font-size: 18px;
            width: 90px;
            height: 30px;
        }

        .container {
            background-color: white;
            width: 900px;
            padding-top: 5px;
        }

        .textCenter {
            text-align: center;
            border-right: 2px solid;
        }
        
        .alert {
            color: red;
            font-size: 18px;
            text-align: center;
            margin-bottom: 5px;
        }
        
    </style>
</head>
<body>
    <div class="topBar">顧客一覧</div>
    <div class="parnentContainer">
        <div class="container-fluid">
            <div class="alert">${message}</div>
            <form action="List" method="post">
                <div class="row">
                    <div class="col-xs-1"></div>
                    <div class="col-xs-3">お客様番号</div>
                    <div class="col-xs-8">
                        <input
                            type="text"
                            name="CustomerId"
                            class="textBox"
                        />
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-1"></div>
                    <div class="col-xs-3">名前</div>
                    <div class="col-xs-8">
                        <input
                            type="text"
                            name="Name"
                            class="textBox"
                        />
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-1"></div>
                    <div class="col-xs-3">電話番号</div>
                    <div class="col-xs-8">
                        <input
                            type="text"
                            name="Tel"
                            class="textBox"
                        />
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-1"></div>
                    <div class="col-xs-3">利用期間</div>
                    <div class="col-xs-8">
                        <select name="Duration" class="select">
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
                        <select name="Type" class="select">
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
                        <select name="Net" class="select">
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
            <div class="buttons">
                <input type="submit" value="検索" class="button" style="float: left;">
            </form>
                <form action="AddCustomer" method="post">
                    <input type="submit" value="新規追加" class="button" style="float: right;">
                </form>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <table style="border: 2px solid; width: 100%">
                        <tr>
                            <td style="width: 12%" class="textCenter">詳細表示</td>
                            <td style="width: 22%" class="textCenter">お客様番号</td>
                            <td style="width: 22%" class="textCenter">名前</td>
                            <td style="width: 22%" class="textCenter">登録日</td>
                            <td style="width: 22%" class="textCenter">最終更新日</td>
                        </tr>
                        <c:if test = "${findListModel != null}">
                            <c:set var = "i" value = "0" scope = "request" />
                            <c:forEach var = "item" items = "${findListModel.getAllCustomerList()}">
                                <tr style="border-top: 2px solid;">
                                    <td class="textCenter">
                                        <form action="EditCustomer" method="post">
                                            <input type="hidden" name = "CustomerId" value="${item.getCustomerId()}">
                                            <input type="submit" value="詳細">
                                        </form>
                                    </td>
                                    <td class="textCenter">${item.getCustomerId()}</td>
                                    <td class="textCenter">${item.getName()}</td>
                                    <td class="textCenter">${item.getAddDay()}</td>
                                    <td class="textCenter">${item.getUpdateDay()}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>