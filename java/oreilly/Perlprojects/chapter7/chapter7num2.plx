#2. [6] Modify the previous program to allow Fred to match as well. Does it
#   match now if your input string is Fred, frederick, or Alfred? (Add lines
#   with these names to the text file.)

#! usr/bin/perl

use strict;
use warnings;

open(INPUTFILE, "<input.txt");

while(<INPUTFILE>)
{

   my($line) = $_;

   if(/Fred/)
   {

      print "$_\n";
   }

}

close(INPUTFILE);


