window.onload = init;
                
function init() {
                
    var petsSpan = document.getElementById("pets");
    var landscapeSpan = document.getElementById("landscape");
    var oceanSpan = document.getElementById("ocean");
                
    petsSpan.onclick = selectPets;
    landscapeSpan.onclick = selectLandscape;
    oceanSpan.onclick = selectOcean;
                
    var links = document.querySelectorAll("a");
    for (var i = 0; i < links.length; i++) {
        links[i].onclick = addImage;
    }
}
                
function selectPets() {
    var ul = document.getElementById("petsList");
    showHide(ul);
}
                
function selectLandscape() {
     var ul = document.getElementById("landscapeList");
     showHide(ul);
}
                
function selectOcean() {
    var ul = document.getElementById("oceanList");
    showHide(ul);
}
                
function showHide(el) {
    // deselect everything
    var selectedItems = document.querySelectorAll(".show");
    for (var i = 0; i < selectedItems.length; i++) {
        if (selectedItems[i] != el) {
            selectedItems[i].setAttribute("class", "");
        }
    }
                
    var ulClass = el.getAttribute("class");
    if (ulClass == "show") {
        // item is selected, so deselect it
        el.setAttribute("class", "");
    }
    else {
        // item is not selected, so select it
        el.setAttribute("class", "show");
    }
}
                
function addImage(e) {
    var a = e.target;
    var imagePath = a.getAttribute("href");

    var image = document.createElement("img");
    image.setAttribute("src", imagePath);

    var div = document.getElementById("image");
    
    var oldImage = document.querySelector("img");
    if(oldImage){
      var oldImageParent = oldImage.parentElement;
      oldImageParent.removeChild(oldImage);
    }
    
    div.appendChild(image);
    return false;
}