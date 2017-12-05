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
            <h1>BOOKERS ADMINISTRATION PAGE</h1>
            <div>
                <table>
                    <tr>
                        <td align="left">
                            <span class="menu_icon" onclick="openNav()">&#9776; Menu</span>
                        </td>
                        </tr>
                        </table>
                        </div>
                <div id="menu_side" class="sidenav">
	                <ul class="menuList">
	                    <li style="float:right">
	                        <a href="javascript:void(0)" onclick="closeNav()">&times;</a>
	                    </li>
	                    <li><a class="adminMenu" href="AdminServlet?action=addbook">Add books</a></li>
	                    <li><a class="adminMenu" href="AdminServlet?action=updatebook">Update books</a></li>
	                    <li><a class="adminMenu" href="AdminServlet?action=deletebook">DeleteBook</a></li>
	                    <li><a class="adminMenu" href="AdminServlet?action=createpromo">Create Promotion</a></li>
	                    <li><a class="adminMenu" href="AdminServlet?action=addemployee">Add Employees</a></li>
	                    <li><a class="adminMenu" href="AdminServlet?action=suspendacct">Suspend Account</a></li>  
	                    <li><a class="adminMenu" href="AdminServlet?action=manageuser">Manage Users</a></li>
	                    <li><a class="adminMenu" href="AdminServlet?action=managesupplier">Manage Suppliers</a></li>
	                    <li><a class="adminMenu" href="AdminServlet?action=manageshipper">Manage Shippers</a></li>
	                    <li><a class="adminMenu" href="AdminServlet?action=viewsales">View End of Day Sales Reports</a></li>
	                    <li><a class="adminMenu" href="AdminServlet?action=viewinventory">View Inventory Report</a></li>
	                    <li><a class="adminMenu" href="AdminServlet?action=viewpublisher">View Publisher Report</a></li>  
	                    <li><a class="adminMenu" href="HomeServlet?action=logout">Log Out</a></li>     
	                </ul>
            </div>
			  <div>
                <img src = "images/books.jpg" alt="banner">
            </div>
            <div class="slideshow-container">
                <div class="mySlides fade" name="slideShow">
                    <div class="numbertext">1 / 2</div>
                    <img src="images/slideShowImage1.jpg" style="width:100%">
                    <div>Promotion Code: BUYNOW</div>
                </div>
                <div class="mySlides fade" name="slideShow">
                    <div class="numbertext">2 / 2</div>
                    <img src="images/slideShowImage2.jpg" style="width:100%">
                    <div>Best Seller</div>
                </div>
                <br>
                <div style="text-align:center">
                    <span class="dot" name="dots"></span> 
                    <span class="dot" name="dots"></span> 
                </div>
            </div>
            <h3> ${hello} </h3>
            <div>
                <img class = "stars" src = "images/five-stars.png">
                <p class = "HomeReview-text">I've always had good service from The Online Bookstore...I use it to buy most of my books.</p>
                <p class = "HomeReview-author">-Bob</p>
                <p class = "HomeReview-stats">
                    <strong>Posted </strong>
                </p>
                <p class ="HomeReview-stats">
                    2 reviews on The Online Bookstore! | Latest review 1 hour ago
                </p>
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