#5. [8] Make a program that prints each line that has a two of the same 
#   nonwhitespace characters next to each other. It should match lines
#   that contain words such as Mississippi, Bamm-Bamm, or llama.

#! usr/bin/perl

use strict;
use warnings;

open(INPUTFILE, "<input3.txt");

while(<INPUTFILE>)
{

  if(/(\S)\1/)
  {

    print "$_\n";

  }

}

close(INPUTFILE);

