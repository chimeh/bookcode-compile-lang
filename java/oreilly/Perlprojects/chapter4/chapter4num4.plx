#4. [10] Write a subroutine named greet that welcomes the person
#   you name by telling them the name of the last person it greeted:

#! usr/bin/perl

use strict;
use warnings;

my($number) = 0;
my(@name)   = 0;
my($name)   = 0;
my($inc)    = 0;
my($length) = 0;

print "How many people are in your party?\n";
$number = <STDIN>;

print "Please enter your name:\n";

@name = <STDIN>;
 
$length = chomp(@name);

if($length < $number)
{
    print "You did not provide enough names in your party.\n";
    exit (1);
}

if($length > $number)
{
    print "The number of names listed is greater that your party size.\n";
    exit(1);
}

greetings($number, @name);

sub greetings
{
  $inc = 1;

  if($number == 1)
  {
    print "Hello ", $name , " you're the first one here.\n";
  }

  else
  {

    print "Hello ", $name[0] , " you're the first one here.\n";

    while($inc < $number)
    {

      print "Hello ", $name[$inc] , ", " , $name[$inc-1] , " is also here.\n";
      ++$inc;    
    }

  }

}
