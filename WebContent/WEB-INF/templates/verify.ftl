<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>
            Bookers
        </title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="scripts/script.js"></script>
    <head>
    <body>
        <div class="main">
            <h1>BOOKERS</h1>
            <div align="center" style="padding:5px">
            <h3>Hello ${name}, we have sent you an email with a verification code. Please enter the code below to verify your account. </h3>
            <form action="HomeServlet" method="get">
            	<center>
            		Code: <input style="width:100px" type="text" name="code"><br><br>
            		<input style="width:100px" type="submit" value="verify" name="verify">
            	</center>
            </form>
            </div>
        </div>
        <div class="FooterStatsContent">
            <div class="FooterStats-stat">
                <img class = "icons" src = "https://image.flaticon.com/icons/svg/29/29302.svg">
                <div class="FooterStats-content">
                    <h3>2</h3>
                    <p>Books Sold</p>
                </div>
            </div>

            <div class="FooterStats-stat">
                <img class = "icons" src ="https://www.fnbabsecon.com/wp-content/uploads/2016/06/piggy-bank-icon.png">
                
                <div class="FooterStats-content">
                    <h3>$2</h3>
                    <p>Customer Savings</p>
                </div>
            </div>
                
            <div class="FooterStats-stat">
                <img class = "icons" src ="https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/Thumb_up_icon_2.svg/1000px-Thumb_up_icon_2.svg.png">

                <div class="FooterStats-content">
                    <h3>100%</h3>
                    <p>Satisfaction Guarantee</p>
                </div>
            </div>
            
            <div class="FooterStats-stat">
                <img class = "icons" src ="http://iconshow.me/media/images/ui/ios7-icons/png/512/star_2.png">
                <div class="FooterStats-content">
                    <h3>1</h3>
                    <p>5 Star Ratings</p>
                </div>
            </div>
        </div>
    </body>
</html>