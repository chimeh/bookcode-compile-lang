window.onload = init;

function Guitar(brand, model, serialNum, colors, discount){
  this.brand = brand;
  this.model = model;
  this.serialNum = serialNum;
  this.colors = colors;
  this.discount = discount;
}

function init(){

  var newGuitar = Guitar("Fender", "Stratocaster", 8675309, ["yellow", "white", "black"], true);
  var guitarJSON = JSON.stringify(newGuitar);
  console.log("guitarJSON");
  
  
  
}