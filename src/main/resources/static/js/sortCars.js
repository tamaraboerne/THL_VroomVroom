document.addEventListener('DOMContentLoaded', function () {
    sortCars(); // Rufe die Sortierfunktion beim Laden der Seite auf, um die Kacheln nach Preis aufsteigend anzuzeigen
});

// Funktion zum Sortieren der Autos
function sortCars() {
    const sortOption = document.getElementById('sortOptions').value;
    const tilesContainer = document.querySelector('.tiles');

    const tilesArray = Array.from(tilesContainer.children);

    tilesArray.sort((a, b) => {
        const priceA = parseFloat(a.querySelector('p').innerText);
        const priceB = parseFloat(b.querySelector('p').innerText);

        return (sortOption === 'aufsteigend') ? priceA - priceB : priceB - priceA;
    });

    // Entferne vorhandene Tiles aus dem Container
    tilesArray.forEach(tile => tilesContainer.removeChild(tile));

    // Füge die sortierten Tiles zurück in den Container ein
    tilesArray.forEach(tile => tilesContainer.appendChild(tile));
}