<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 05.06.2023
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      <span class= "h1">Табло текущего теннисного матча</span>
    </div>
  </div>
</header>

<section>
  <div class="container">
    <div class="table-general">
      <div><div class="table-title">
        <p class="text-title">Match №</p>
      </div></div>
      <div><div class="table-sign">
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
      </div></div>
      <div><div class="table-score">
        <div class="col-prev-sets ml-6 mr-6">
          <div class="col-score-set">
            <p class="text-score">1</p>
          </div>
          <div class="col-score-set">
            <p class="text-score">2</p>
          </div>
          <div class="col-score-set">
            <p class="text-score">3</p>
          </div>
          <div class="col-score-set">
            <p class="text-score">4</p>
          </div>
        </div>
        <div class="col-player">
          <div class="player">
            <p class="text-player">roger federer</p>
          </div>
        </div>
        <div class="col-serve">
          <div class="serve">
            <img src="https://pngimg.com/uploads/tennis/small/tennis_PNG10405.png" width="40" height="40" alt="">
          </div>
        </div>
        <div class="col-sets mr-6 ml-6">
          <div class="col-score-set">
            <p class="text-score">4</p>
          </div>
        </div>
        <div class = "col-points mr-6 ml-6" >
          <div class="col-score-points">
            <p class="text-score">15</p>
          </div>
        </div>
        <div class="col-but">
          <div class="btn-wrapper">
            <form method="post">
              <button class="btn" name="player-1" value="player-1-win">Take score #1</button>
            </form>
          </div>
        </div>

      </div></div>
      <div class = "empty"></div>
      <div><div class="table-score">
        <div class="col-prev-sets ml-6 mr-6">
          <div class="col-score-set">
            <p class="text-score">6</p>
          </div>
          <div class="col-score-set">
            <p class="text-score">6</p>
          </div>
          <div class="col-score-set">
            <p class="text-score">2</p>
          </div>
          <div class="col-score-set">
            <p class="text-score">6</p>
          </div>
        </div>
        <div class="col-player">
          <div class="player">
            <p class="text-player">rafael nadal</p>
          </div>
        </div>
        <div class="col-serve">
          <div class="serve">
            <img src="https://pngimg.com/uploads/tennis/small/tennis_PNG10405.png" width="40" height="40" alt="">
          </div>
        </div>
        <div class="col-sets mr-6 ml-6">
          <div class="col-score-set">
            <p class="text-score">4</p>
          </div>
        </div>
        <div class = "col-points mr-6 ml-6" >
          <div class="col-score-points">
            <p class="text-score">40</p>
          </div>
        </div>
        <div class="col-but">
          <div class="btn-wrapper">
            <form method="post">
              <button class="btn" name="player-2" value="player-2-win">Take score #2</button>
            </form>
          </div>
        </div>
      </div></div>
    </div>

  </div>


</section>
</body>
</html>
