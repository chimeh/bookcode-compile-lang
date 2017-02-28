#5. [10] Modify the previous program to tell each new person the names of all
#   the people it has previously greeted:

#! usr/bin/perl

use strict;
use warnings;

my($number) = 0;
my(@name)   = 0;
my($name)   = 0;
my($inc)    = 0;
my($inc2)   = 0;
my($length) = 0;

print "How many people are in your party?\n";
$number = <STDIN>;

print "Please enter your name:\n";
@name = <STDIN>;

print "\n";

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

print "\n";

sub greetings
{
  $inc = 1;

  if($number == 1)
  {
    print "Hi ", $name , "! you're the first one here.\n";
  }

  else
  {

    print "Hi ", $name[$inc - $number] , "! you're the first one here.\n";

    while($inc < $number)
    {
      $inc2 = 0;
      print "Hi ", $name[$inc] , "! I've seen: ";
      while($inc2 < $inc)
      {
        print $name[$inc2] , " ";
        ++$inc2;
      }
      print "\n";
      ++$inc;    
    }

  }

}

