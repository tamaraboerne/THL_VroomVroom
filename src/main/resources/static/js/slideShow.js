 // Quelle: timetoprogram.com
let currentSlide = 0;

function startSlider() {
    let imageCount = document.querySelectorAll("img");
    let images = document.querySelector("ul");

    if (imageCount.length === 0) {
        imageCount = document.querySelectorAll("img");
        images.style.transform = `translateX(0px)`;
        return;
    }

    images.style.transform = `translateX(-${currentSlide * 600}px)`;

    // Remove the active class from all dots
    let dots = document.querySelectorAll(".dot");
    dots.forEach((dot) => {
        dot.classList.remove("active");
    });

    // Add the active class to the current dot
    dots[currentSlide].classList.add("active");

    if (currentSlide === imageCount.length - 1) {
        currentSlide = 0;
    } else {
        currentSlide++;
    }
}

setInterval(() => {
    startSlider();
}, 3000);
