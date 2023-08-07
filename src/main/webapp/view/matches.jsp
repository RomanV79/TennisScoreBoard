<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Завершенные матчи</title>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ page isELIgnored="false" %>
</head>
<body>
<header>
    <div class="container bc-lightgray">
        <div class="table-header p-20">
            <span class="h1">Завершенные матчи</span>
        </div>
    </div>
</header>
<section>
    <div class="container">
        <div class="table-general p-20">
            <div>
                <p style="padding-bottom: 20px;"><a style="color: white;" href="index.jsp">На главную</a></p>
            </div>
            <div>
                <form action="" method="get">
                    <div>
                        <input type="text" name="filter_by_player_name" placeholder="Марат Сафин" style="width: 200px">
                    </div>
                    <div style="margin-top: 10px; margin-bottom: 10px;">
                        <button style="width: 200px; padding: 10px; border-radius:5px 5px 5px 5px; border: 0px;"
                                type="submit">Отфильтровать
                        </button>
                        <a href="?filter_by_player_name=">
                            <button type="button"
                                    style="width: 200px; padding: 10px; border-radius:5px 5px 5px 5px; border: 0px; background-color: red; color: white">
                                Сбросить фильтр
                            </button>
                        </a>
                    </div>
                </form>
            </div>
            <div>
                <table style="width: 100%; background: lightgray; border-collapse: collapse;">
                    <tr>
                        <th style="width: 6%; text-align: left; padding: 5px;">Number</th>
                        <th style="width: 6%; text-align: left; padding: 5px;">
                        <th style="width: 41%; text-align: left; padding: 5px;">Player #1</th>
                        <th style="width: 6%; text-align: left; padding: 5px;"></th>
                        <th style="width: 41%; text-align: left; padding: 5px;">Player #2</th>
                    </tr>
                    <c:forEach var="match" items="${matches}">
                        <tr style="border-top: 1px solid black; border-bottom: 1px solid black;">
                            <td style="width: 6%; padding: 5px;">${match.id}</td>
                            <td style="width: 6%; padding: 5px; text-align: right">
                                <c:if test = "${match.player1.name eq match.winner.name}"><img src="<%=request.getContextPath()%>/images/cup-600-600.png"
                                           width="20" height="20" alt="">
                                </c:if></td>
                            <td style="width: 41%; padding: 5px;">${match.player1.name}</td>
                            <td style="width: 6%; padding: 5px; text-align: right"">
                                <c:if test = "${match.player2.name eq match.winner.name}"><img src="<%=request.getContextPath()%>/images/cup-600-600.png"
                                                                                               width="20" height="20" alt="">
                                </c:if></td>
                            <td style="width: 41%; padding: 5px;">${match.player2.name}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div style="display: flex; white-space: normal; justify-content: center">
                <c:if test="${currentPage != 0}">
                    <a href="?page=${currentPage - 1}">
                        <p style="padding: 10px; color: white">Previous</p>
                    </a>
                </c:if>
                <c:if test="${currentPage lt qntOfPage -1}">
                    <a href="?page=${currentPage + 1}">
                        <p style="padding: 10px; color: white">Next</p>
                    </a>
                </c:if>
            </div>
        </div>
    </div>
</section>

</body>
</html>
