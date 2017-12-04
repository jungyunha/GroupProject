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
            <h1>BOOKERS SHIPPER PAGE</h1>
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
                    <li><a class="adminMenu" href="ShipperServlet?ShipperAction=updateorder">Update Order Status</a></li>
                    <li><a class="adminMenu" href = "index.html">Logout</a></li>
                </ul>
            </div>
            <form action="ShipperServlet" method="post">
            <center> <h3> Update Order Status </h3>
            <div style="height:300px">
                Transaction ID: &emsp;&emsp;&emsp;&emsp;<input type="text" style="width:150px" name="transactionid"><br><br>
                Set order status to: &emsp;&emsp;&emsp;&emsp;&ensp;<select style="height:18px" name="orderstatus">
		                            	<option value="notyet">Not yet shipped</option>
		                                <option value="shipped">Shipped</option>
		                                <option value="delivered">Delivered</option>
		                            </select> <br> <br>
		        <input type="submit" value="Update Order Status" name="updateStatus" style="height:50px;width:150px">
            </div>
            </center>
            </form>
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

