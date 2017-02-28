#3. [6] Make a program that prints each line of its input that contains a
#   period (.), ignoring other lines of input. Try it on the small text file
#   from the previous exercise: does it notice Mr. Slate?

#! usr/bin/perl

use strict;
use warnings;

open(INPUTFILE, "<input1.txt");

while(<INPUTFILE>)
{

   if(/\./)
   {
     print "$_\n";
   }
}

close(INPUTFILE);
