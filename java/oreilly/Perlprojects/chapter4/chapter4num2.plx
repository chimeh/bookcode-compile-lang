#2. [5] Using the subroutine from the previous problem, make a program to
#   calculate the sum of the numbers from 1 to 1,000.

#! usr/bin/perl

use strict;
use warnings;

my(@list) = 1..1000;
my($inc)  = 0;
my($list) = 0;
my($sum)  = 0;
my($mysum)= 0;

$mysum  = sum(@list);

print "The sum of the numbers from 1 to 1000 is: " , $mysum , "\n\n";


sub sum
{
  chomp(@list);

  foreach $list(@list)
  {

    $sum = $sum + $list[$inc];

    $inc++;

  }

  return $sum;

}
