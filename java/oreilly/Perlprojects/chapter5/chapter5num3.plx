#[8] Modify the previous program to let the user choose the column width, so
#    that entering 30, hello, good-bye (on separate lines) would put the
#    strings at the 30th column. (Hint: see “Interpolation of Scalar Variables
#    into Strings” on page 32 in Chapter 2, about controlling variable
#    interpolation.) For extra credit, make the ruler line longer when the
#    selected width is larger.

#! usr/bin/perl

use strict;
use warnings;

my(@list) = 0;
my($justified) = 0;
my($inc) = 0;

print "Please enter how much character you want",
      "the list to be right-justified:\n";
chomp($justified = <>);

print "Please enter a list of crap you wanted to be listed",
      "as right-justified:\n";
@list = <>;

printf "%s-character right justified\n", $justified;
while($inc < $justified)
{
  print "=";
  ++$inc;
}
print "\n";

foreach $_(@list)
{
  printf "%${justified}s", $_;
}
print"\n";
