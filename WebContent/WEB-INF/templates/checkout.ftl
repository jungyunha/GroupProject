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
                            Search By: <input style="height:18px" type="text" value="Name, Author, ISBN or All"/>
                            <select style="height:18px">
                                <option value="all">All</option>
                                <option value="name">Name</option>
                                <option value="author">Author</option>
                                <option value="isbn">ISBN</option>
                            </select>
                        </td>
                        <td align='right'>
                            <span>Not Logged In</span>
                        </td>
                    </tr>
                </table>
            </div>
            <div id="menu_side" class="sidenav">
                <ul class="menuList">
                    <li style="float:right">
                        <a href="javascript:void(0)" onclick="closeNav()">&times;</a>
                    </li>
                     <li><a href="#">My Account</a></li>
                    <li><a href="#">My Cart</a></li>
                    <li><a href="#">Order History</a></li>
                    <li><a href="login.html">Log Out</a></li>  
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
