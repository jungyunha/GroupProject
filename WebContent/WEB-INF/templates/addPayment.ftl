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
            <div>
                <table>
                    <tr>
                        <td align="left">
                            <span class="menu_icon" onclick="openNav()">&#9776; Menu</span>
                        </td>
                        <td class="search" align='center'>
                            <form action="HomeServlet" method="post">
                            Search: <input style="height:18px;width:200px" type="text" name="searchValue"/> by 
                            <select style="height:18px" name="searchType">
                            	<option value="title">Title</option>
                                <option value="subject">Subject</option>
                                <option value="author">Author</option>
                                <option value="isbn">ISBN</option>
                            </select>
                            <input type="submit" value="Search" name="searchBook" style="width:100px" />
                        </form>
                        </td>
                    </tr>
                </table>
            </div>
            <div id="menu_side" class="sidenav">
                <ul class="menuList">
                    <li style="float:right">
                        <a href="javascript:void(0)" onclick="closeNav()">&times;</a>
                    </li>
                    <li><a href="HomeServlet?action=home">Home</a></li>
                    <li><a href="HomeServlet?mycart=yes">My Cart</a></li>
                    <li><a href="HomeServlet?history=yes">Order History</a></li>
                    <li><a href="HomeServlet?gotoEditProfile=42">Edit Profile</a></li>
                    <li><a href="HomeServlet?action=logout">Log Out</a></li>     
                </ul>
            </div>
            <div align="center">
                <p align="center">ENTER PAYMENT INFORMATION</p>
                <form action="HomeServlet" method="post">
                    <table class="registration">
                        <tr><td class="registrationForm">Cardholder Name: </td>        <td class="registrationInput"><input type="text" required></td></tr>
                        <tr><td class="registrationForm">Card type: </td>        <td class="registrationInput"><select style="height:18px;width:150px" name="cardType">
																					                            	<option value="visa">VISA</option>
																					                                <option value="master">MasterCard</option>
																					                                <option value="amex">American Express</option>
																					                                <option value="discover">Discover</option>
																					                            </select></td></tr>
                        <tr><td class="registrationForm">Card Number: </td>      <td class="registrationInput"><input type="text" required></td></tr>
                        <tr><td class="registrationForm"><img src="images/creditCard.png"></img></td><td class="registrationInput"></td></tr>
                        <tr><td class="registrationForm">Billing Address: </td>   <td class="registrationInput"><input type="text" required></td></tr>
                        <tr><td class="registrationForm">Billing Zip Code: </td>  <td class="registrationInput"><input type="text" style="width:6em" required></td></tr>
                    </table>
                    <input type="submit" class="submitRegistration" name="submitPayment" value="Add Payment">
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