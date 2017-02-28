window.onload = init;

// Declaring the boxes array and counter globally so they can be used by all the funcitons
var boxes = new Array();
var counter = 0;

// Declaring the construcor for a Box object as defined by the requirements
function Box(id, boxName, color, x, y){
  this.id = id;
  this.boxName= boxName;
  this.color = color;
  this.x = x;
  this.y = y;
}

//Assigning the click handlers for both of the buttons
function init(){
  // Retrieving both element objects for the buttons so I can assign a function to be called upon them being clicked
  var generateButton = document.getElementById("generateButton");
  var clearButton = document.getElementById("clearButton");
  
  // Call the generate() function if the Generate button is clicked and the clear() function if it is clicked.
  generateButton.onclick = generate;
  clearButton.onclick = clear;
}

function generate(){
  // Declaring all the variables I will need to complete the generation of the boxes and correctly display them on the screen.
  // Retreived all the elements from the DOM and additionally created the checkedAmount variable to determine how many boxes to create.
  // The 'i' variable is to assist with iterating through each box creation.
  var boxColorIndex = document.getElementById("color");
  var boxColor = boxColorIndex.options[boxColorIndex.selectedIndex].text;
  var name = document.getElementById("name").value;
  var sceneDiv = document.getElementById("scene");
  var selectFive = document.getElementById("five")
  var selectTen = document.getElementById("ten");
  var selectFifteen = document.getElementById("fifteen");
  var checkedAmount = 0;
  var i = 0;
  
  // Created a conditional so that we can determine which radio button is checked for the amount of boxes to be made and assigning
  // this value to checkedAmount to assist with the iterations. If none are checked then tell the person they need to check one.
  if(selectFive.checked){
    checkedAmount = 5;
  }
  else if(selectTen.checked){
    checkedAmount = 10; 
  }
  else if(selectFifteen.checked){
    checkedAmount = 15; 
  }
  else{
    alert("Choose a number!");
  }
    
    // Iterating through the creation process of the div's and the boxes based on the checkAmount.
    while(i < checkedAmount){
      // Randomly creating an x and y value to use for the position of the divs
      var x = Math.floor(Math.random() * (sceneDiv.offsetWidth-101));
      var y = Math.floor(Math.random() * (sceneDiv.offsetHeight-101));
      // Created a new div to be put on the screen and a corresponding Box object that will hold the properties for that div
      var newDiv = document.createElement("div");
      var newBox = new Box(counter, name, boxColor, x, y);
      // Added each Box object to an array to be stored
      boxes[counter] = newBox;
      // Assigned all of the Box properties to the new div that will be placed on the screen and also assigned a
      // click handler so that when these new div's are clicked they will run the display function.
      newDiv.id = boxes[counter].id;
      newDiv.className = "box";
      newDiv.style.background = boxes[counter].color;
      newDiv.style.left = x + "px";
      newDiv.style.top = y + "px";
      newDiv.onclick = display;
      newDiv.innerHTML = boxes[counter].boxName;
      // Added the new div to the screen
      sceneDiv.appendChild(newDiv);
      // Incremented the counter to keep track of how many boxes/div's we have
      counter += 1;
      i++;
    }
    
    
}

function clear(){
  // Retrieved each of the elements that will need to be reset to their original values and the reset them
  var sceneDiv = document.getElementById("scene");
  document.getElementById("name").value = "";
  document.getElementById("color").selectedIndex = 0;
  document.getElementById("five").checked = false;
  document.getElementById("ten").checked = false;
  document.getElementById("fifteen").checked = false;
  counter = 0;
  boxes = [];
  
  // Running a while loop to remove all of the div's until no child div's exists under the 'scene' div
  while(sceneDiv.firstChild){
    sceneDiv.removeChild(sceneDiv.firstChild);
  } 
  
  
}

function display(){
  // Called an alert and used the ID of the div to determine which Box object it corresponds to in the array and displayed those values.
  alert(
  "ID: " + this.id + "\n" +
  "Name: " + boxes[this.id].boxName + "\n" +
  "Color: " + boxes[this.id].color + "\n" +
  "X: " + boxes[this.id].x + "\n" +
  "Y: " + boxes[this.id].y
  );
}