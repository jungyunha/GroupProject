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
         <div id="wrapper">
            
            <h2> Checkout </h2>
            
            <img id="cart" src="https://image.flaticon.com/icons/svg/2/2772.svg" alt="cart">
            
            <div id="cartInfo"> 
                You have (${numberOfItems}) items in your cart.
                <br><br>
                <form action="HomeServlet" method="post" id="payment">
                    <br>
                    <br><br>
                    Your selected payment method: ${payment}
                    <br><br><br><br>
                    Total price of order: ${totalPrice}. <br>
                    Press the Place Order button to place your order. 
                    <br><br><br><br>
                    <input id="placeOrder" type="submit" value="Place Order" name="placeOrder">
                </form>
            
            </div>
        
        </div>
    </body>
</html>
