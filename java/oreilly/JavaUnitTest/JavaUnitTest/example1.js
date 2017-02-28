/**
 * 
 */
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
<!--
var name;
var age;
var occupation;
//var enteredValue= new Boolean(false);
//alert(enteredValue);
function promptUser(){
    
    promptName();   
    promptAge();
    promptOccupation();
    writeResults();
}

funtion noValueEntered(){
    alert("You have to enter a value");
}
    
    

function promptName(){
    name=window.prompt("Enter Your Name:","name");
    
}
function promptAge(){
    age=window.prompt("Enter Your Age:","age");
}
function promptOccupation(){
    occupation=window.prompt("Enter Your Occupation:","occupation");
}
function writeResults(){
    document.write("<h1> Your Results</h1>");
    document.write("<ul><li>Name:"+name);
    document.write("<li>Name:"+age);
    document.write("<li>Name:"+occupation);
}





//-->
</script>
</head>
<body onload="promptUser();">
</body>
<html>