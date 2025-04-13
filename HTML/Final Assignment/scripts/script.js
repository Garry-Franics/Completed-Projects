const myImages = ['images/img1.jpg',
    'images/img2.jpg',
    'images/img3.jpg',
    'images/img4.jpg',
    'images/img5.jpg'
]; //array of the pictures that can be shown

let currentIndex = 0; //sets the first image
displayImage(currentIndex); //displays the first image when site is opened

function displayImage(index) {
    const ImageContainer = document.getElementById('imageContainer'); //sets the location the picture is being replaced
    const imageUrl = myImages[index]; //sets the url of the picture being replaced
    ImageContainer.innerHTML = `<img src="${imageUrl}"alt="Image ${index + 1}">`; //replaces the picture with the next one in the array
}

function nextImage() {
    currentIndex = (currentIndex + 1) % myImages.length; //gets the next avalable image
    displayImage(currentIndex); //displays current image
}

function submit() {
    const name = document.getElementById('name').value; //gets what was put in the name text input
    const phone = document.getElementById('phone').value; //gets what was put in the phone text input
    const email = document.getElementById('email').value; //gets what was put in the email text input
    const aoi = document.getElementById('aoi').value; //gets what was put in the area of interest text input
    const userConfirmed = confirm(`Do you want to submit the registration?\nName: ${name}\nPhone: ${phone}\nEmail: ${email}\nArea of Interest: ${aoi}`); //gives the conformation alert
    if (userConfirmed) {
        document.getElementById('name').value = ''; //clears the name text input
        document.getElementById('phone').value = ''; //clears the phone text input
        document.getElementById('email').value = ''; //clears the email text input
        document.getElementById('aoi').value = ''; //clears the area of interest text input
    }
}

document.getElementById('imageContainer').addEventListener('click', nextImage); //event listener for the picture
document.getElementById('register').addEventListener('click', submit); //event listener for the register button