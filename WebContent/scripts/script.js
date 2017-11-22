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
                
function openNav() {
    document.getElementById("menu_side").style.width = "15%";
}

function closeNav() {
    document.getElementById("menu_side").style.width = "0";
}