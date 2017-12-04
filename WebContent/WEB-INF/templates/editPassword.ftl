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
            
            <div align="center">
                <p align="center">REGISTRATION FORM</p>
                <form action="HomeServlet" method="post" >
                    <table class="editProfile">
                        <tr>
                        	<td class="registrationForm">Current Password: </td>         
                        	<td class="registrationInput"><input type="text" name="password" required></td>
                        </tr>
                        <tr>
                        	<td class="registrationForm">New Password: </td>         
                        	<td class="registrationInput"><input type="text" name="newpassword" required></td>
                        </tr>
                        <tr>
                        	<td class="registrationForm">Re-Enter New Password: </td>
                        	<td class="registrationInput"><input type="text" name="newpassword2" required></td>
                        	<td><h5 style="color:red">${pwd_error!""}</h5></td>
                        </tr>
                    </table>
                    <input type="submit" class="submitRegistration" name="editPassword">
                </form>
            </div>
            
            <br><br><br><br>
            <p id="returnHome"><a href="">Return to Home Page</a></p>
        
        </div>
    </body>
</html>