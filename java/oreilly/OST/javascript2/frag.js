window.onload = init;

function init(){
  var colors = ["red", "blue", "green" ];
  var container = document.getElementById("container");
  var fragment = document.createDocumentFragment();
  for(var i=0; i < 3; i++){
    var box = document.createElement("div");
    box.setAttribute("class", "box");
    box.style.backgroundColor = colors[i];
    fragment.appendChild(box);
  }
  container.appendChild(fragment);
}