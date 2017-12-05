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
            <h1>BOOKERS ADMINISTRAION</h1>
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
                <p align="center">Suspend Account</p>
                <form action="AdminServlet" method="post">
                    <table class="registration">
                        <tr><td class="registrationForm">User ID: </td>            <td class="registrationInput"><input type="number" name="suspendID"></td></tr>
                    </table><br>
                      <input type="submit"  class="SubmitRegistration" value="Suspend Account" name="suspendacct"/><br><br>
                </form>
                <h3 style="color:red">${message}</h3><br>
            </div>
        </div>
	</body>
</html>