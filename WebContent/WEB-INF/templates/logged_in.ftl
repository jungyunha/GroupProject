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
                            <span>Welcome ${first} ${last}!</span>
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
                    <li><a href="HomeServlet?mycart=yes">My Cart</a></li>
                    <li><a href="#">Order History</a></li>
                    <li><a href="HomeServlet?gotoEditProfile=42">Edit Profile</a></li>
                    <li><a href="login.html">Log Out</a></li>
                </ul>
            </div>
            <h2> ${message} </h2>
            <div>
                <img src = "images/books.jpg" alt="banner">
            </div>
            <script>
                var slideIndex = 0;
                showSlides();
                function showSlides() {
                    var i;
                    var slides = document.getElementsByName("slideShow");
                    var dots   = document.getElementsByName("dots");
                    for (i = 0; i < slides.length; i++) {
                        slides[i].style.display = "none";  
                    }	
                    slideIndex++;
                    if (slideIndex> slides.length) {
                        slideIndex = 1;
                    }    
                    for (i = 0; i < dots.length; i++) {
                        dots[i].className = dots[i].className.replace(" active", "");
                    }
                    slides[slideIndex-1].style.display = "block";  
                    dots[slideIndex-1].className += " active";
                    setTimeout(showSlides, 7000); // Change image every 7 seconds
                }
            </script>
            <div class="slideshow-container">
                <div class="mySlides fade" name="slideShow">
                    <div class="numbertext">1 / 2</div>
                    <img src="images/slideShowImage1.jpg" style="width:100%">
                    <div>Promotion Code: BUYNOW</div>
                </div>
                <div class="mySlides fade" name="slideShow">
                    <div class="numbertext">2 / 2</div>
                    <img src="images/slideShowImage2.jpg" style="width:100%">
                    <div>Best Seller</div>
                </div>
                <br>
                <div style="text-align:center">
                    <span class="dot" name="dots"></span> 
                    <span class="dot" name="dots"></span> 
                </div>
            </div>
            <div>
                <img class = "stars" src = "images/five-stars.png">
                <p class = "HomeReview-text">I've always had good service from The Online Bookstore...I use it to buy most of my books.</p>
                <p class = "HomeReview-author">-Bob</p>
                <p class = "HomeReview-stats">
                    <strong>Posted </strong>
                </p>
                <p class ="HomeReview-stats">
                    2 reviews on The Online Bookstore! | Latest review 1 hour ago
                </p>
            </div>
        </div>
        <div class="FooterStatsContent">
            <div class="FooterStats-stat">
                <img class = "icons" src = "https://image.flaticon.com/icons/svg/29/29302.svg">
                <div class="FooterStats-content">
                    <h3>2</h3>
                    <p>Books Sold</p>
                </div>
            </div>

            <div class="FooterStats-stat">
                <img class = "icons" src ="https://www.fnbabsecon.com/wp-content/uploads/2016/06/piggy-bank-icon.png">
                
                <div class="FooterStats-content">
                    <h3>$2</h3>
                    <p>Customer Savings</p>
                </div>
            </div>
                
            <div class="FooterStats-stat">
                <img class = "icons" src ="https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/Thumb_up_icon_2.svg/1000px-Thumb_up_icon_2.svg.png">

                <div class="FooterStats-content">
                    <h3>100%</h3>
                    <p>Satisfaction Guarantee</p>
                </div>
            </div>
            
            <div class="FooterStats-stat">
                <img class = "icons" src ="http://iconshow.me/media/images/ui/ios7-icons/png/512/star_2.png">
                <div class="FooterStats-content">
                    <h3>1</h3>
                    <p>5 Star Ratings</p>
                </div>
            </div>
        </div>
    </body>
</html>