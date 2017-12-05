<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="scripts/script.js"></script>
<title>Admin Sales Report</title>
</head>
<body>
	<div class = "main">
		<h1>Your Order History</h1>
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
                <li><a href="HomeServlet?history=yes">Order History</a></li>
                <li><a href="HomeServlet?gotoEditProfile=42">Edit Profile</a></li>
                <li><a href="HomeServlet?action=logout">Log Out</a></li>
		    </ul>
		</div>
		<#if showHistory>
		<table style="width:70%;color:black;" align="center">
			<tr>
				<th>Transaction ID</th>
				<th>Date/Time</th>
				<th>Total Amount Paid</th>
				<th>Order Status</th>
			</tr>
			<#list transactions as transaction>
			<tr>
				<td align="center">${transaction.transactionID}</td>
				<td align="center">${transaction.date}</td>
				<td align="center">$${transaction.totalAmountPaid}</td>
				<td align="center">${transaction.status}</td>
			</tr>
			</#list>
		</table>
		<#else>
			<h3>You have no previous orders. Better get to shopping! </h3>
		</#if>
	</div>
</body>
</html>