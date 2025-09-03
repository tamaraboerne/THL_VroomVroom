var everythingvalidated = [false,false,false,false,false,false,false,false,false,false,false,false,false,true,true, true, true, true];

// validating der eingabe der plz und gegebenenfalls anzeigen von fehlermeldungen fuer den user
function validatePLZ(inputId, errorId, errorMessage, boolId) {
    var ErrorElement = document.getElementById(errorId)

    var InputElement = document.getElementById(inputId)
    var InputValue = InputElement.value;
    // input 5 numbers only
    var regex = new RegExp("^\\d{5}$");

    if(regex.test(InputValue)) {
        // remove error border
        InputElement.classList.remove('wrong-input');
        // remove error message
        hideError(ErrorElement);

        // bool true for validation button
        everythingvalidated[boolId] = true;
    } else {
        // show border and message
        InputElement.classList.add('wrong-input');
        displayError(ErrorElement, errorMessage);
        everythingvalidated[boolId] = false;
    }
}


function validateStrNotEmpty(inputId, errorId, errorMessage, boolId) {
    var ErrorElement = document.getElementById(errorId)

    var InputElement = document.getElementById(inputId)
    var InputValue = InputElement.value;

    // trim spaces
    InputValue.trim();

    if (InputValue === '') {
        // show border and message
        InputElement.classList.add('wrong-input');
        displayError(ErrorElement, errorMessage);
        everythingvalidated[boolId] = false;
    }else {
        // remove error border and message
        InputElement.classList.remove('wrong-input');
        hideError(ErrorElement);
        everythingvalidated[boolId] = true;
    }
}




function handleBlurLeistung(inputId, errorId, errorMessage) {
    validateStrNotEmpty(inputId, errorId, errorMessage);

    // check on numbers only and add ps if so
    var inputElement = document.getElementById(inputId);
    var inputValue = inputElement.value;

    // Regex für nur Zahlen
    var regex = /^\d*$/;

    if (regex.test(inputValue) && inputValue.trim() !== '') {
        // Wenn es keine reine Zahl ist, fuege 'PS' hinzu
        // fuege ebenfalls kw mit umrechnung von 0.74 / 1 hinzu
        const kw = inputValue * 0.74;
        inputElement.value = inputValue + 'PS / ' + kw + 'kW';
    }
}


// event listener um falsche eingaben beim preis zu vermeiden
document.getElementById('preisInput').addEventListener('input', function() {
    var inputValue = this.value;
    var regex = /^\d{1,5}(\.\d{0,2})?$/;

    if (!regex.test(inputValue)) {
        this.value = inputValue.slice(0, -1);
    }
});

// event listener um die anzahl der sitze zu kontrollieren
document.getElementById('sitzeInput').addEventListener('input', function() {
    var inputValue = this.value;
    var regex = /^[1-7]$/;

    if (!regex.test(inputValue)) {
        this.value = inputValue.slice(0, -1);
    }
});


// selected option validieren fuer die drop down menues
function validateSelectedOption(inputId, errorId, errorMessage, boolId) {
    var selectedOption = document.getElementById(inputId).value;
    var errorElement = document.getElementById(errorId);

    var InputElement = document.getElementById(inputId)

    if (selectedOption === 'Null') {
        InputElement.classList.add('wrong-input');
        displayError(errorElement, errorMessage);
        everythingvalidated[boolId] = false;
    } else {
        InputElement.classList.remove('wrong-input');
        hideError(errorElement);
        everythingvalidated[boolId] = true;
    }
}



// variables for "Fahrzeug inserieren" button validation
var inputsToValidate = ['leistungInput', 'strInput', 'strInput2', 'hnInput', 'hnInput2', 'plzInput', 'plzInput2', 'ortInput', 'ortInput2',
                                'markInput' , 'preisInput', 'sitzeInput', 'modellInput'];

var dropDownsToValidate = ['kategorieInput', 'treibstoffInput', 'getInput'];
var dropDownsErrors = ['kategorieError', 'treibstoffError', 'getError'];

var errorIds = ['leistungError', 'strError', 'strError2', 'hnError', 'hnError2', 'plzError', 'plzError2', 'ortError', 'ortError2',
                        'markError', 'preisError', 'sitzeError', 'modellError'];

var errorMessage = 'Feld ist leer!';


// button validierung um sicherzustellen das alle felder gefüllt sind
function validateAndSubmit(inputId) {
    for (var i = 0; i < inputsToValidate.length; i++) {
        validateStrNotEmpty(inputsToValidate[i], errorIds[i], errorMessage, i);
    }

    for (var j = 0; j < dropDownsToValidate.length; j++) {
        validateSelectedOption(dropDownsToValidate[j], dropDownsErrors[j], errorMessage, j + 15)
    }

    // prüfe ob alles richtig gefüllt
    if (everythingvalidated.every(function (element) {
        return element === true;
    })) {
        //alert('Alle Felder sind korrekt ausgefüllt!');
        window.location.href = '/startseite';
        //document.getElementById(inputId).href = 'startseite.html';
    } else {
        document.getElementById(inputId).href = 'javascript:void(0)';
        //alert('nicht true!');
    }
}



// anzeigen der fehlermeldung fuer falsche eingabe
function displayError(element, errorMessage) {
    element.textContent = errorMessage;
    element.style.display = 'block';
}


// loeschen der fehlermeldung
function hideError(element) {
    element.textContent = '';
    element.style.display = 'none';
}