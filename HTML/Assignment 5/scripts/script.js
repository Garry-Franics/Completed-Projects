function PTK() {
    var num = parseFloat(document.getElementById('num').value); //gets input from the textbox
    var result = (num * 0.4536).toFixed(2); //converts pounds to kilograms
    document.getElementById('result').innerText = num + " pounds is equal to " + result + " kilograms."; //outputs result
}

function KTP() {
    var num = parseFloat(document.getElementById('num').value); //gets input from the textbox
    var result = (num * 2.2).toFixed(2); //converts kilograms to pounds
    document.getElementById('result').innerText = num + " kilograms is equal to " + result + " pounds."; //outputs result
}

document.getElementById('buttonPTK').addEventListener('click', PTK); //creates action listener for the pounds to kilograms button
document.getElementById('buttonKTP').addEventListener('click', KTP); //creates action listener for the kilograms to pounds button