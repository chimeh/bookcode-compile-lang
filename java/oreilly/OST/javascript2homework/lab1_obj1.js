// Invoking the init function once the window loads
window.onload = init;

// Declaring the Guitar constructor so that we may instaniate objects.
// Accepts the brand name, the model name, the serial number, colors on the guitar, and whether a discount applies to the guitar as parameters.
function Guitar(brand, model, serialNum, colors, discount){
  this.brand = brand;
  this.model = model;
  this.serialNum = serialNum;
  this.colors = colors;
  this.discount = discount;
}

function init(){
  // Instantiating Guitar object with provided arguments
  var newGuitar = new Guitar("Fender", "Stratocaster", 8675309, ["yellow", "white", "black"], true);
  // Creating a JSON object via the stringify method. Passing the newGuitar object through as an argument
  var guitarJSON = JSON.stringify(newGuitar);
  // Outputting the guitar object in JSON
  console.log(guitarJSON);
  // Deserializing the JSON guitar object back into a JavaScript object.
  var deserializedGuitar = JSON.parse(guitarJSON);
  // Outputting the JavaScript guitar object
  console.log(deserializedGuitar);
  
}