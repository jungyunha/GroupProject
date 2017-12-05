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
                	<li><a class="adminMenu" href="AdminServlet?action=adminhome">Home</a></li>
                    <li><a class="adminMenu" href="AdminServlet?action=addbook">Add books</a></li>
                    <li><a class="adminMenu" href="AdminServlet?action=updatebook">Update books</a></li>
                    <li><a class="adminMenu" href="AdminServlet?action=deletebook">Delete Book</a></li>
                    <li><a class="adminMenu" href="AdminServlet?action=createpromo">Create Promotion</a></li>
                    <li><a class="adminMenu" href="AdminServlet?action=addemployee">Add Employees</a></li>
                    <li><a class="adminMenu" href="AdminServlet?action=suspendacct">Suspend Account</a></li>  
                    <li><a class="adminMenu" href="AdminServlet?action=manageuser">Manage Users</a></li>
                    <li><a class="adminMenu" href="AdminServlet?action=viewsales">View End of Day Sales Reports</a></li>
                    <li><a class="adminMenu" href="AdminServlet?action=viewinventory">View Inventory Report</a></li>
                    <li><a class="adminMenu" href="AdminServlet?action=viewallsales">View Total Sales Report</a></li>  
                    <li><a class="adminMenu" href="HomeServlet?action=logout">Log Out</a></li>      
                </ul>
            </div>
      		 <div align="center">
                <p align="center">Update User</p>
                <form action="AdminServlet" method="post">
                    <table class="registration">
                        <tr><td class="registrationForm">User Id: </td>       <td class="registrationInput" ><input type="number" name="userid"></td></tr>
                        <tr><td class="registrationForm">First Name: </td>        <td class="registrationInput"><input type="text" name="fname"></td></tr>
                        <tr><td class="registrationForm">Last Name: </td>            <td class="registrationInput"><input type="text" name="lname"></td></tr>
                        <tr><td class="registrationForm">Phone Number: </td>          <td class="registrationInput"><input type="text" name="phone"></td></tr>
						<tr><td class="registrationForm">Email: </td>          <td class="registrationInput"><input type="text" name="email"></td></tr>
						<tr><td class="registrationForm">Password: </td>          <td class="registrationInput"><input type="text" name="password"></td></tr>
						<tr><td class="registrationForm">Shipping Address </td>          <td class="registrationInput"><input type="text" name="shipaddress"></td></tr>
						<tr><td class="registrationForm">Billing Address </td>          <td class="registrationInput"><input type="text" name="billaddress"></td></tr>
                    </table>
                      <input type="submit"  class="SubmitRegistration" value="Edit User" name="manageusers"/>
                </form>
            </div>
    </body>
</html>
	</body>
</html>
