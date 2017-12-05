<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="scripts/script.js"></script>
<title>Manager Inventory Report</title>
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
		        <li><a class="adminMenu" href="ManagerServlet?ManagerAction=managerhome">Home</a></li>
                <li><a class="adminMenu" href="ManagerServlet?ManagerAction=viewinventory">View Inventory Report</a></li>
                <li><a class="adminMenu" href="ManagerServlet?ManagerAction=viewsales">View End of Day Sales Report</a></li>
                <li><a class="adminMenu" href="ManagerServlet?ManagerAction=totalsales">View Total Sales Report</a></li>  
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