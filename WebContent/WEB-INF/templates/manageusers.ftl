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
            <h2> View Customer </h2>
                <img id="profile" src="https://ubmemeaensoprod.s3.amazonaws.com/FI_webroot/styles/responsive_grid_scaled_and_cropped/public/team_member_photos/2016/08/profile-no-picture-male.png?itok=dqf2_02a" alt="img">
            
                <table>
                    <tr><td>First Name: </td>       <td>Michael</tr>
                    <tr><td>Last Name: </td>        <td>Johnson</td></tr>
                    <tr><td>Email: </td>            <td>mj342535@gmail.com</td></tr>
                    <tr><td>Phone #: </td>          <td>(555)712-3340</td></tr>
                    <tr><td>Mailing Address: </td>  <td>123 Pleasant Lane</td></tr>
                </table>
                <br><br>
                <input type="button" value="Edit Customer">
                <input type="button" value="Remove Customer">
        </div>
    </body>
</html>
	</body>
</html>
