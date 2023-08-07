<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Табло текущего матча</title>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
</head>
<body>
<header>
    <div class="container bc-lightgray">
        <div class="table-header p-20">
            <span class="h1">Табло текущего теннисного матча</span>
        </div>
    </div>
</header>
<section>
    <div class="container">
        <div class="table-general">
            <div>
                <div class="table-title">
                    <p class="text-title">Match №</p>
                </div>
            </div>
            <div>
                <div class="table-sign">
                    <div class="col-prev-sets ml-6 mr-6">
                        <p class="text-sign">previous sets</p>
                    </div>
                    <div class="col-player">
                        <p class="text-sign">player</p>
                    </div>
                    <div class="col-serve">
                        <p class="text-sign"></p>
                    </div>
                    <div class="col-sets mr-6 ml-6">
                        <p class="text-sign">sets</p>
                    </div>
                    <div class="col-points mr-6 ml-6">
                        <p class="text-sign">points</p>
                    </div>
                    <div class="col-but">
                        <p class="text-sign"></p>
                    </div>
                </div>
            </div>
            <div>
                <div class="table-score">
                    <div class="col-prev-sets ml-6 mr-6">
                        <div class="col-score-set">
                            <c:if test="${currentMatch.firstScore.listSet.size() == 0}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.firstScore.listSet.size() > 0}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.firstScore.listSet.get(0)}"></c:out></p>
                            </c:if>
                        </div>
                        <div class="col-score-set">
                            <c:if test="${currentMatch.firstScore.listSet.size() < 2}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.firstScore.listSet.size() > 1}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.firstScore.listSet.get(1)}"></c:out></p>
                            </c:if>
                        </div>
                        <div class="col-score-set">
                            <c:if test="${currentMatch.firstScore.listSet.size() < 3}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.firstScore.listSet.size() > 2}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.firstScore.listSet.get(2)}"></c:out></p>
                            </c:if>
                        </div>
                        <div class="col-score-set">
                            <c:if test="${currentMatch.firstScore.listSet.size() < 4}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.firstScore.listSet.size() > 3}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.firstScore.listSet.get(3)}"></c:out></p>
                            </c:if>
                        </div>
                    </div>
                    <div class="col-player">
                        <div class="player">
                            <p class="text-player">${currentMatch.firstPlayer.name}</p>
                        </div>
                    </div>
                    <div class="col-serve">
                        <div class="serve">
                            <c:if test="${currentMatch.serveFirstPlayer}">
                                <img src="https://pngimg.com/uploads/tennis/small/tennis_PNG10405.png" width="40"
                                     height="40" alt="">
                            </c:if>
                        </div>
                    </div>
                    <div class="col-sets mr-6 ml-6">
                        <div class="col-score-set">
                            <p class="text-score">${currentMatch.firstScore.scoreGame}</p>
                        </div>
                    </div>
                    <div class="col-points mr-6 ml-6">
                        <div class="col-score-points">
                            <c:if test="${currentMatch.stage eq 'NORMAL'}">
                                <p class="text-score">${currentMatch.firstScore.scorePoint.pointCode}</p>
                            </c:if>
                            <c:if test="${currentMatch.stage eq 'TIEBREAK'}">
                                <p class="text-score">${currentMatch.firstScore.scoreTieBreak}</p>
                            </c:if>
                        </div>
                    </div>
                    <div class="col-but">
                        <div class="btn-wrapper">
                            <form method="post">
                                <c:if test="${currentMatch.stage ne 'END'}">
                                    <button class="btn" name="player-1" value="player-1-win">Take score #1</button>
                                </c:if>
                            </form>
                        </div>
                    </div>

                </div>
            </div>
            <div class="empty"></div>
            <div>
                <div class="table-score">
                    <div class="col-prev-sets ml-6 mr-6">
                        <div class="col-score-set">
                            <c:if test="${currentMatch.secondScore.listSet.size() == 0}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.secondScore.listSet.size() > 0}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.secondScore.listSet.get(0)}"></c:out></p>
                            </c:if>
                        </div>
                        <div class="col-score-set">
                            <c:if test="${currentMatch.secondScore.listSet.size() < 2}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.secondScore.listSet.size() > 1}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.secondScore.listSet.get(1)}"></c:out></p>
                            </c:if>
                        </div>
                        <div class="col-score-set">
                            <c:if test="${currentMatch.secondScore.listSet.size() < 3}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.secondScore.listSet.size() > 2}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.secondScore.listSet.get(2)}"></c:out></p>
                            </c:if>
                        </div>
                        <div class="col-score-set">
                            <c:if test="${currentMatch.secondScore.listSet.size() < 4}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.secondScore.listSet.size() > 3}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.secondScore.listSet.get(3)}"></c:out></p>
                            </c:if>
                        </div>
                    </div>
                    <div class="col-player">
                        <div class="player">
                            <p class="text-player">${currentMatch.secondPlayer.name}</p>
                        </div>
                    </div>
                    <div class="col-serve">
                        <div class="serve">
                            <c:if test="${not currentMatch.serveFirstPlayer}">
                                <img src="https://pngimg.com/uploads/tennis/small/tennis_PNG10405.png" width="40"
                                     height="40" alt="">
                            </c:if>
                        </div>
                    </div>
                    <div class="col-sets mr-6 ml-6">
                        <div class="col-score-set">
                            <p class="text-score">${currentMatch.secondScore.scoreGame}</p>
                        </div>
                    </div>
                    <div class="col-points mr-6 ml-6">
                        <div class="col-score-points">
                            <c:if test="${currentMatch.stage eq 'NORMAL'}">
                                <p class="text-score">${currentMatch.secondScore.scorePoint.pointCode}</p>
                            </c:if>
                            <c:if test="${currentMatch.stage eq 'TIEBREAK'}">
                                <p class="text-score">${currentMatch.secondScore.scoreTieBreak}</p>
                            </c:if>
                        </div>
                    </div>
                    <div class="col-but">
                        <div class="btn-wrapper">
                            <form method="post">
                                <c:if test="${currentMatch.stage ne 'END'}">
                                    <button class="btn" name="player-2" value="player-2-win">Take score #2</button>
                                </c:if>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <c:if test="${currentMatch.stage eq 'END'}">
                <div>
                    <div class="table-result-title">
                        <p class="result-title">winner</p>
                    </div>
                    <div class="table-result">
                        <p style="font-size: 18px; font-weight: bold">${currentMatch.winner.name}</p>
                    </div>
                    <div style="background-color: lightgray; margin-bottom: 0px; margin-top: -10px; padding-bottom: 15px;">
                        <a href="index.jsp">
                            <button type="submit" class="card_button" style="font-size: 14px;">Continue</button>
                        </a>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</section>
</body>
</html>
