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
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(1, 0) == -1}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(1, 0) != -1}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.matchScore.getGameResultsInSet(1, 0)}"></c:out></p>
                            </c:if>
                        </div>
                        <div class="col-score-set">
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(2, 0) == -1}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(2, 0) != -1}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.matchScore.getGameResultsInSet(2, 0)}"></c:out></p>
                            </c:if>
                        </div>
                        <div class="col-score-set">
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(3, 0) == -1}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(3, 0) != -1}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.matchScore.getGameResultsInSet(3, 0)}"></c:out></p>
                            </c:if>
                        </div>
                        <div class="col-score-set">
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(4, 0) == -1}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(4, 0) != -1}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.matchScore.getGameResultsInSet(4, 0)}"></c:out></p>
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
                            <c:if test="${currentMatch.matchScore.serve == 0}">
                                <img src="https://pngimg.com/uploads/tennis/small/tennis_PNG10405.png" width="40"
                                     height="40" alt="">
                            </c:if>
                        </div>
                    </div>
                    <div class="col-sets mr-6 ml-6">
                        <div class="col-score-set">
                            <c:if test="${currentMatch.matchScore.getPlayerScore(0) != currentMatch.setForWin
                                    and currentMatch.matchScore.getPlayerScore(1) != currentMatch.setForWin}">
                                <p class="text-score">${currentMatch.matchScore.currentSet.getPlayerScore(0)}</p>
                            </c:if>
                            <c:if test="${currentMatch.matchScore.getPlayerScore(0) + currentMatch.matchScore.getPlayerScore(1) == 5}">
                                <p class="text-score">${currentMatch.matchScore.currentSet.getPlayerScore(0)}</p>
                            </c:if>
                            <c:if test="${(currentMatch.matchScore.getPlayerScore(0) == currentMatch.setForWin
                                    or currentMatch.matchScore.getPlayerScore(1) == currentMatch.setForWin)
                                    and (currentMatch.matchScore.getPlayerScore(0) + currentMatch.matchScore.getPlayerScore(1)) != 5}">
                                <p class="text-score">0</p>
                            </c:if>
                        </div>
                    </div>
                    <div class="col-points mr-6 ml-6">
                        <div class="col-score-points">
                            <p class="text-score">${currentMatch.matchScore.getCurrentGameScore(0)}</p>
                        </div>
                    </div>
                    <div class="col-but">
                        <div class="btn-wrapper">
                            <form method="post">
                                <c:if test="${currentMatch.matchScore.getPlayerScore(0) != currentMatch.setForWin
                                    and currentMatch.matchScore.getPlayerScore(1) != currentMatch.setForWin}">
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
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(1, 1) == -1}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(1, 1) != -1}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.matchScore.getGameResultsInSet(1, 1)}"></c:out></p>
                            </c:if>
                        </div>
                        <div class="col-score-set">
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(2, 1) == -1}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(2, 1) != -1}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.matchScore.getGameResultsInSet(2, 1)}"></c:out></p>
                            </c:if>
                        </div>
                        <div class="col-score-set">
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(3, 1) == -1}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(3, 1) != -1}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.matchScore.getGameResultsInSet(3, 1)}"></c:out></p>
                            </c:if>
                        </div>
                        <div class="col-score-set">
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(4, 1) == -1}">
                                <p class="text-score" style="color: black">.</p>
                            </c:if>
                            <c:if test="${currentMatch.matchScore.getGameResultsInSet(4, 1) != -1}">
                                <p class="text-score"><c:out
                                        value="${currentMatch.matchScore.getGameResultsInSet(4, 1)}"></c:out></p>
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
                            <c:if test="${currentMatch.matchScore.serve == 1}">
                                <img src="https://pngimg.com/uploads/tennis/small/tennis_PNG10405.png" width="40"
                                     height="40" alt="">
                            </c:if>
                        </div>
                    </div>
                    <div class="col-sets mr-6 ml-6">
                        <div class="col-score-set">
                            <c:if test="${currentMatch.matchScore.getPlayerScore(0) != currentMatch.setForWin
                                    and currentMatch.matchScore.getPlayerScore(1) != currentMatch.setForWin}">
                                <p class="text-score">${currentMatch.matchScore.currentSet.getPlayerScore(1)}</p>
                            </c:if>
                            <c:if test="${currentMatch.matchScore.getPlayerScore(0) + currentMatch.matchScore.getPlayerScore(1) == 5}">
                                <p class="text-score">${currentMatch.matchScore.currentSet.getPlayerScore(1)}</p>
                            </c:if>
                            <c:if test="${(currentMatch.matchScore.getPlayerScore(0) == currentMatch.setForWin
                                    or currentMatch.matchScore.getPlayerScore(1) == currentMatch.setForWin)
                                    and (currentMatch.matchScore.getPlayerScore(0) + currentMatch.matchScore.getPlayerScore(1)) != 5}">
                                <p class="text-score">0</p>
                            </c:if>
                        </div>
                    </div>
                    <div class="col-points mr-6 ml-6">
                        <div class="col-score-points">
                            <p class="text-score">${currentMatch.matchScore.getCurrentGameScore(1)}</p>
                        </div>
                    </div>
                    <div class="col-but">
                        <div class="btn-wrapper">
                            <form method="post">
                                <c:if test="${currentMatch.matchScore.getPlayerScore(0) != currentMatch.setForWin
                                    and currentMatch.matchScore.getPlayerScore(1) != currentMatch.setForWin}">
                                    <button class="btn" name="player-2" value="player-2-win">Take score #2</button>
                                </c:if>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <c:if test="${currentMatch.matchScore.getPlayerScore(0) == currentMatch.setForWin
                    or currentMatch.matchScore.getPlayerScore(1) == currentMatch.setForWin}">
                <div>
                    <div class="table-result-title">
                        <p class="result-title">winner</p>
                    </div>
                    <div class="table-result">
                        <p style="font-size: 18px; font-weight: bold">${currentMatch.winner.name}</p>
                    </div>
                    <div style="background-color: lightgray; margin-bottom: 0px; margin-top: -10px; padding-bottom: 15px;">

                        <form action="end-match" method="post">
                            <input type="hidden" value="${currentMatch.uuid}" name="uuid">
                            <button type="submit" class="card_button" style="font-size: 14px;">Continue</button>
                        </form>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</section>
</body>
</html>