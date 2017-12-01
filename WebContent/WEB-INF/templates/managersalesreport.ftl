<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="scripts/script.js"></script>
<title>Manager Sales Report</title>
</head>
<body>
	<div class = "main">
		<h1>End of Day Sales</h1>
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
		        <li><a class="adminMenu" href="ManagerServlet?ManagerAction=viewinventory">View Inventory Report</a></li>
                <li><a class="adminMenu" href="ManagerServlet?ManagerAction=viewsales">View End of Day Sales Report</a></li>
                <li><a class="adminMenu" href="ManagerServlet?ManagerAction=viewpublisher">View Publisher Report</a></li>  
                <li><a class="adminMenu" href = "index.html">Logout</a></li>
		    </ul>
		</div>
		<table style="width:70%" align="center">
			<tr>
				<th>Sales</th>
				<th>ISBN</th>
				<th>Subject</th>
				<th>Author</th>
				<th>Book name</th> 
			</tr>
			<tr>
				<td> 5 </td>
				<td>978-0321573513</td>
				<td>Computer Science</td>
				<td>Robert Sedgewick</td>
				<td>Algorithms (4th Edition)</td>
			</tr>
			<tr>
				<td> 3</td>
				<td>978-0393929720</td>
				<td>Statistics</td>
				<td>David Freedman</td>
				<td>Statistics, 4th Edition</td>
			</tr>
			<tr>
				<td> 10</td>
				<td>978-0618502981</td>
				<td>Calculus</td>
				<td>Ron Larson</td>
				<td>Calculus 8th Edition</td>
			</tr>
			<tr>
			  	<td> 3</td>
			    <td>978-1133187790</td>
			    <td>Computer Science</td>
			    <td>Michael Sipser</td>
			    <td>Introduction to the Theory of Computation 3rd Edition</td>
			</tr>
			<tr>
			  	<td> 12</td>
			    <td>978-0393614053</td>
			    <td>Chemistry</td>
			    <td>Thomas R. Gilbert</td>
			    <td>Chemistry: An Atoms-Focused Approach (Second Edition)</td>
			</tr>
			<tr>
			  	<td> 40</td>
			    <td>978-0321775658</td>
			    <td>Biology</td>
			    <td>Jane B. Reece</td>
			    <td>Campbell Biology (10th Edition)</td>
			</tr>
		</table>
	</div>
</body>
</html>