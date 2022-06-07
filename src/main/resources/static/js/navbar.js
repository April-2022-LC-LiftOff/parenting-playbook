let navSlide = () => {
let burger = document.querySelector('.burger');
let nav = document.querySelector('.navbar-nav');
let navLinks = document.querySelectorAll('.navbar-nav li');


    burger?.addEventListener('click', () => {
        nav.classList.toggle('nav-active');

        navLinks.forEach((link, index) => {
            if(link.style.animation) {
             link.style.animation = '';
            } else {
             link.style.animation = `navLinkFade 0.5s ease forwards ${index / 7 + 0.1}s`;
            }
        });

        burger.classList.toggle('toggle');
    });
}

navSlide();








