#1. [12] Write a subroutine, named total, which returns the total of a list
#    of numbers. Hint: the subroutine should not perform any I/O; it should
#    simply process its parameters and return a value to its caller. Try it
#    out in this sample program, which merely exercises the subroutine to see
#    that it works.

#! usr/bin/perl

use strict;
use warnings;

print "Please enter a list of number(s) (press Ctrl+D once finished): ";
my(@list) = <STDIN>;
my($inc) = 0;
my($list) = 0;
my($total) = 0;
my($mytotal) = 0;


$mytotal = total(chomp(@list));

print "total is: " , $mytotal , "\n\n";

sub total
{
  
  foreach $list(@list)
  {

    $total = $total + $list[$inc];

    $inc++;
  }
  
   return $total;
}
