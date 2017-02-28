// Declaring this array globally so we can acess the JSON data from any of the functions
var tweetsArray = new Array();
// Kicking off the process to retrieve and display the data
window.onload = init;

function init(){
  // Retrieve the tweets from the JSON file and display them on the page
  getTwitterData();
}

function getTwitterData(){
  // Instantiating the request object of type XMLHttpRequest so we have a mechanism to interact with the JSON file
  var request = new XMLHttpRequest();
  // Sending a HTTP GET request to the server so we can retrieve the file named twitterJSON.json
  request.open("GET", "twitterJSON.json");
  // Once the request has a state change to ready then do this
  request.onreadystatechange = function(){
    // Checking to see if the state is done and we got a 200 which indicates we got what we were looking for
    if(this.readyState == this.DONE && this.status == 200){
      // If we have some response text from our call to the JSON file then proceed
      if(this.responseText){
        // Read the response text from the JSON file and make it so JavaScript can understand what it's saying
        parseTweets(this.responseText);
        // Add the parsed information from the JSON file to the HTML page.
        addTweetsToPage();
      }
      else {
        // Didn't find any tweets
        console.log("Error: No data returned");
      }
    }

  };
  // Send off the constructed request
  request.send();
}

function parseTweets(twitterJSON){
  // If the function is given a null or blank argument then stop and return to the previous function
  if(twitterJSON == null || twitterJSON.trim() == ""){
    return;
  }
  // Parsing the responseText and saving it in a variable so we can use it in JavaScript
  var tweets = JSON.parse(twitterJSON);
  // If we get nothing when attempting to parse the text, then log it in the console, stop here, and return to the previous function
  if(tweets.length == 0){
    console.log("No tweets to be tweeted");
    return;
  }
  // Iterating through the objects we got from parsing the JSON file and adding them to the global array we made
  for(var i = 0; i < tweets.length; i++){
     var singleTweet = tweets[i];
     tweetsArray.push(singleTweet);
  }
}

function addTweetsToPage(){
  // Getting the parent element so we can add to the list
  var ul = document.getElementById("twitterData");
  // Iterating through each tweet object and adding the pertinent info to the page
  for(var i = 0; i < tweetsArray.length; i++){
    var li = document.createElement("li");
    var tweet = tweetsArray[i];
    li.innerHTML = 
      tweet.user.name + ": " + tweet.text; 
    ul.appendChild(li);
  }
  
}