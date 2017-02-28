#[8] Write a program that asks the user to enter a list of strings on separate
#    lines, printing each string in a right-justified, 20-character column. To
#    be certain that the output is in the proper columns, print a “ruler line”
#    of digits as well. (This is simply a debugging aid.) Make sure that you’re
#    not using a 19-character column by mistake!

#! usr/bin/perl

use strict;
use warnings;

my(@list) = 0;

print "\nPlease enter a list of crap, enter Ctrl+D once finished:\n";
@list = <>;


print "20-character, right justified\n\n";
print "====================\n";

foreach $_(@list)
{
  printf  ("%21s", $_);
}
