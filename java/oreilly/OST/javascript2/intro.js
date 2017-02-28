function Pet(type, name, weight, likes){
  this.type = type;
  this.name = name;
  this.weight = weight;
  this.likes = likes;
}

window.onload = init;

function init(){
    var pickles = new Pet("cat", "Pickles", 7, ["sleeping", "purring", "eating butter"]);
    var picklesJSON = JSON.stringify(pickles);
    console.log(picklesJSON);
    
    var anotherPickles = JSON.parse(picklesJSON);
    console.log(anotherPickles);

    var tilla = new Pet("dog", "Tilla", 25, ["sleeping","eating","walking"]);
    
    var petsArray = [ pickles, tilla ];
    var petsArrayJSON = JSON.stringify(petsArray);

}