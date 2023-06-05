<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 03.06.2023
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Большой теннис</title>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
</head>
<body>
<header>
    <div class="container bc-lightgray">
        <div class="table-header p-20">
            <span class="h1">Большой теннис</span>
        </div>
    </div>
</header>
<section>
    <div class="container">
        <div class="main">
            <a class="start-link" href="new-match">Начать новый матч</a>
            <a class="start-link" href="match">Завершенные матчи</a>
        </div>
    </div>
</section>

</body>
</html>
