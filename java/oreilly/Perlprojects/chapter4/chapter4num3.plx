#3. [18] Extra credit exercise: write a subroutine, called &above_average,
#   which takes a list of numbers and returns the ones which are above the
#   average (mean). (Hint: make another subroutine that calculates the average
#   by dividing the total by the number of items.) Try your subroutine in this
#   test program.

#! usr/bin/perl

use strict;
use warnings;


print "Please enter the list of grades, enter Ctrl+D once finished:\n";
my(@grades) = <STDIN>;

print "\n\n";

my($sum)         = 0; #holds the sum of all the grades in the list
my($grades)      = 0; #a grade in the list of grades
my($inc)         = 0; #incrementor
my($avg)         = 0; #holds the average of all the grades
#holds the return value of get_avg subroutine
my($myavg)       = get_avg(@grades);
my($myabove_avg) = 0; #holds the value that is above average
#holds the values that are above average
my(@myabove_avg) = above_avg(@grades, $myavg);
my(@aboveavglist)= 0; #return list of above_avg
#incrementor that only increments if the current grade is above average
my($true)        = 0;

print "Class average is: " , $myavg , "\n\n";

print "The following are grades above average: ";

  foreach $myabove_avg(@myabove_avg)
  {

    print $myabove_avg , " ";

  }

  print "\n\n";

sub get_avg
{

  chomp(@grades);

  foreach $grades(@grades)
  {

    $sum = $sum + $grades[$inc];

    ++$inc;

  }

  $avg = ($sum/$inc);

  return $avg;

}

sub above_avg
{

  chomp(@grades);
  
  $inc = 0;
  $true = 0;
  foreach $grades(@grades)
  {

      if($grades[$inc] > $myavg)
      {
  
        $aboveavglist[$true] = $grades[$inc];
        ++$true;

      }

      ++$inc;

  }

  return @aboveavglist;

}
