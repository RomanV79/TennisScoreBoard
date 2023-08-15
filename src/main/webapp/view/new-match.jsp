<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Новый матч</title>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
</head>
<body>
<header>
    <div class="container bc-lightgray">
        <div class="table-header p-20">
            <span class="h1">Новый матч</span>
        </div>
    </div>
</header>
<section>
    <div class="container">
        <div class="main">
            <form action="new-match" method="post">
                <div class="">
                    <input type="text" placeholder="Player #1 Name" id="1" name="player-1" required/>
                </div>
                <div class="">
                    <input type="text" placeholder="Player #2 Name" id="2" name="player-2" required/>
                </div>
                <div class="" style="padding-top: 5px">
                    <select class="form-select" id="match-sets" name="match-sets" required>
                        <option value="">--Please select the quantity of sets in the match--</option>
                        <option value="3">3</option>
                        <option value="5">5</option>
                    </select>
                </div>
                <div>
                    <button class="card_button">Start game</button>
                </div>
            </form>
        </div>
    </div>
</section>

</body>
</html>
