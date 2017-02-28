// Assigning the init function to execute when the page finishes loading.
window.onload = init;

function init(){
  // Calling the getTodoList() function to retreive the needed data for the todoList.html page
  getTodoList();
}

function getTodoList(){
  // Instantiating a XMLHttpRequest object so that we may retrieve the JSON file and assign an action to be executed when the ready state changes
  var request = new XMLHttpRequest(); 
  // Retrieving the todoList.json file
  request.open("GET", "todoList.json");
  // Once we get all the data from that file, do this
  request.onreadystatechange = function(){
  // Getting the two div's available from the HTML document an storing them in variables for later use
  var todoList= document.getElementById("todoList");
  var statusDiv = document.getElementById("status");
  // Checking to see if the request is done and we got a 200 OK HTTP status which indicates all is well.
  if(this.readyState == this.DONE && this.status == 200){
    // If all is well then get the response header and update the status div with the headers Content-type and text
    var type = request.getResponseHeader("Content-Type");
    statusDiv.innerHTML= "<br>Content-type: " + type + "<br>" + this.statusText;
    // Is there any text that was retrieved as part of the request? If so, update the todoList div with said text, otherwise throw an error.
    if(this.responseText){
        todoList.innerHTML = this.responseText;
    }
    else {
        todoList.innerHTML = "Error: no data";
    }
  }
  
  };
  // Off the request goes
  request.send();
}