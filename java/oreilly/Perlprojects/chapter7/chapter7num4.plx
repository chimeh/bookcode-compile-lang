#4. [8] Make a program that prints each line that has a word that is
#   capitalized but not ALL capitalized. Does it match Fred but neither
#   fred nor FRED?

#! usr/bin/perl

use strict;
use warnings;

open(INPUTFILE, "<input2.txt");

while(<INPUTFILE>)
{
   if(/[A-Z]/)
   {

      print "$_\n";
   
   }
}

close(INPUTFILE);

