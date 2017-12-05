<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>
            Bookers
        </title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="scripts/script.js"></script>
        <script>
        </script>
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
                        <td align='right'>
                            <span><h3>Your Cart</h3></span>
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
                    <li><a href="#">Order History</a></li>
                    <li><a href="HomeServlet?gotoEditProfile=42">Edit Profile</a></li>
                    <li><a href="HomeServlet?action=logout">Log Out</a></li>
                </ul>
            </div>
            <div>
          <table class = "carttable">
          <#list books as cartItem>
          <tr>
          	<td> ${cartItem.book.title} </td>
          	<td> x ${cartItem.quantity} </td>
          	<td> $${cartItem.book.price} </td>
          </tr>
          </#list>
 		<tr>
	 		<td> - </td>
	 		<td>Subtotal: </td>
	 		<td>$${subtotal}</td>
 		</tr>
 		<tr>
 			<td> - </td>
 			<td>Tax: </td>
 			<td> $${tax} </td>
 		</tr>
 		<tr>
 			<td> - </td>
 			<td><strong>Total: </strong></td>
 			<td> $${total} </td>
 		</tr>
          </table>
          </div>
            <div id="cartInfo"> 
                You have (${numberOfItems}) items in your cart. Click Add Payment Method to continue.
                <br><br>
                <form action="HomeServlet" method="post" id="payment">
                    <br>
                    <br><br>
                    <input type="submit" value="Add Payment Method" name="addPayment">
                    <br><br><br><br>
                </form>
            </div>
            </div>
    </body>
</html>
