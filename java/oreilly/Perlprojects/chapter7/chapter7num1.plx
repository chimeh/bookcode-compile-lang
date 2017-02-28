#1. [10] Make a program that prints each line of its input that mentions fred.
#   (It shouldn’t do anything for other lines of input.) Does it match if your
#   input string is Fred, frederick, or Alfred? Make a small text file with a
#   few lines mentioning “fred flintstone” and his friends, then use that file
#   as input to this program and the ones later in this section.

#! usr/bin/perl

use strict;
use warnings;

open(INPUTFILE, "<input.txt");

while(<INPUTFILE>)
{

   my($line) = $_;

   if(/fred/)
   {

      print "$_\n";
   }

}

close(INPUTFILE);

