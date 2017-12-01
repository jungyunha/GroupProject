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
                    <li><a href="index.html">Home</a></li>
                    <li><a href="#">My Account</a></li>
                    <li><a href="#">My Cart</a></li>
                    <li><a href="#">Order History</a></li>
                    <li><a href="login.html">Log Out</a></li>     
                </ul>
</div>

<#list books as book>
<figure class="searchbook">
  <img class = "images"  src="${book.coverphoto}"/>
  <div class="price">${book.price}</div>
  <figcaption>
    <h3>${book.title}</h3>
    <p>
      ${book.title} by ${book.author} <br/>
      Rating: ${book.rating}
    </p>
    <#if loggedin>
    	<a href="HomeServlet?addtocart=${book.ISBN}">Add to Cart</a>    	
    </#if>
  </figcaption>
</figure>
</#list>


</div>
</body>
</html>