window.onload = init;

function init(){
  var myObject = {
      name: "Trish",
      age: 29,
      favColor: "blue"
   };
   var myObjectJson = JSON.stringify(myObject);
   localStorage.setItem("trish", myObjectJson);
   var newMyObjectJSON = localStorage.getItem("trish");
   var newMyObject = JSON.parse(newMyObjectJSON);
   alert(newMyObject.name + " is " + newMyObject.age +
       " and her favorite color is " + newMyObject.favColor);
}