#! /usr/bin/perl

print "Please enter radius: ";
$radius = <STDIN>;
$pi	= 3.14159;

if($radius eq "\n" )
{
  print "Invalid radius.\n";
}
if($radius < 0)
{
  print "Radius is: 0\n"; 
}
else
{
  print "The circumference of a circle with a radius ", $radius;
  print " is ", $radius *(2*$pi), ".\n";
}

