window.onload=init;

var colors = new Array();

function init(){
  var submitButton = document.getElementById("submit");
  submitButton.onclick = getFormData;
  getColorItems();
}

function getColorItems(){
  if(localStorage){
    for(var i = 0; i < localStorage.length; i++){
      var key = localStorage.key(i);
      if (key.substring(0,5) == "color"){
        var color = localStorage.getItem(key);
        colors.push(color);
      }
    }
    addColorsToPage();
  }
  else {
    console.log("Error: you don't have localStorage!");
  }
}

function addColorToPage(){
  var ul = document.getElementById("colors");
  
  for(var i =0; i < colors.length; i++){
    var color = colors[i];
    var li = document.createElement("li");
 
    li.innerHTML = color;
    ul.appendChild(li);
  }
}

function getFormData(){
  for(var i = 1; i < 6; i++){
    var color = document.getElementById("color"+i);
    
    if(checkInputText(color.value)){
      colors.push(color.value);
      saveColor(color.value);
    }
  }
  addColorToPage();
  document.forms[0].reset();
  colors.length = 0;
  
}

function checkInputText(value){
  if(value == null || value == ""){
    return false;
  }
  return true;
}

function saveColor(color){
  if(localStorage){
      var key = "color" + localStorage.length;
      localStorage.setItem(key, color);
    }
    else {
      console.log("Error: you don't have localStorage!");
    }
}

function addColorsToPage(){
  var ul = document.getElementById("colors");
  var listFragment = document.createDocumentFragment();
  for(var i = 0; i < colors.length; i++){
    var li = document.createElement("li");
    
    li.innerHTML = colors[i];
    listFragment.appendChild(li);
  }
  ul.appendChild(listFragment);
  colors.length = 0;
}



