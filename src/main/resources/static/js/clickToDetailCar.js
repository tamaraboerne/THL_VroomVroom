function openFDetail(tile) {
    // Extrahieren der Daten aus der angeklickten Kachel
    const carTitleElement = tile.querySelector('h3');
    const tagespreisElement = tile.querySelector('p');

    // Überprüfen, ob die Elemente vorhanden sind
    if (carTitleElement && tagespreisElement) {
        const carTitle = carTitleElement.innerText;
        const tagespreis = tagespreisElement.innerText;

        // Zur Seite mit Fahrzeugdetails weiterleiten, mit Query-Parametern
        window.location.href = `/fahrzeugDetail?title=${encodeURIComponent(carTitle)}&tagespreis=${encodeURIComponent(tagespreis)}`;
    } else {
        console.error("Elements not found within the clicked tile.");
    }
}
