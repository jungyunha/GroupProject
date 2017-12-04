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
                            Search By: <input style="height:18px" type="text" value="Name, Author, ISBN or All"/>
                            <select style="height:18px">
                                <option value="all">All</option>
                                <option value="name">Name</option>
                                <option value="author">Author</option>
                                <option value="isbn">ISBN</option>
                            </select>
                        </td>
                        <td align='right'>
                            <span>CART</span>
                        </td>
                    </tr>
                </table>
            </div>
            <div id="menu_side" class="sidenav">
                <ul class="menuList">
                    <li style="float:right">
                        <a href="javascript:void(0)" onclick="closeNav()">&times;</a>
                    </li>
                    <li><a href="index.html">Home</a></li>
                    <li><a href="login.html">Login</a></li>
                    <li><a href="registration.html">Register</a></li>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Contact Us</a></li>     
                </ul>
            </div>
            <div align="center" style="padding:5px">
                <table style="border:solid 1px" class="loginPageOptions">
                    <tr>
                        <td style="width:50%;border-right:solid 1px">
                            <p>LOGIN</p>
                            <form action="HomeServlet" method="get">
                                <table>
                                    <tr><td style="width:50%">Email or ID: </td>            <td><input style="width:100%;border:1px solid #CCC" type="text" name="username" required></td></tr>
                                    <tr><td style="width:50%">Password: </td>         <td><input style="width:100%;border:1px solid #CCC" type="text" name="pass" required></td></tr>
                                </table>
                                <input type="submit" value="Login" class="submitRegistration" name="login">
                                <input type="submit" value="Forgot Password?" class ="forgotPassword" name = "forgotpassword">
                            </form>
                            <h5 style="color:red">${error}</h5>
                        </td>
                        <td>
                            <p align="center">Or Register</p>
                            <p align="center"><a href="registration.html">Click here to Register</a></p>
                        </td>
                    </tr>
                </table>
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