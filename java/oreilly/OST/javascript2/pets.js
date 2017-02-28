window.onload = init;

function init(){
  getPetData();
}

function getPetData(){
  var request = new XMLHttpRequest();
  request.open("GET", "pets.json");
  request.onreadystatechange = function(){
    var div = document.getElementById("pets");
    if(this.readyState == this.DONE && this.status == 200){
      var type = request.getResponseHeader("Content-Type");
      console.log("Content-type: " + type);
      console.log("Status: " + this.statusText);
      if(this.responseText){
        div.innerHTML = this.responseText;
      }
      else {
        div.innerHTML = "Error: no data";
      }
    }
  };
  request.send();
}