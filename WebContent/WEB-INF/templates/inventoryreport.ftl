<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="scripts/script.js"></script>
<title>Admin Inventory Report</title>
</head>
<body>
	<div class = "main">
		<h1>Inventory Report</h1>
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
		<table style="width:70%;color:black;" align="center">
			<tr>
				<th>Book name</th> 
				<th>Quantity</th>
			</tr>
			<#list books as book>
			<tr>
				<td align="center">${book.title}</td>
				<td align="center">${book.quantity}</td>
			</tr>
			</#list>
		</table>
	</div>
</body>
</html>