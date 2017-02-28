#6. [8] Extra credit exercise: write a program that prints out any input line
#   that mentions both wilma and fred.

#! usr/bin/perl

use strict;
use warnings;

print "Please enter the filename you want as input:\n";

chomp(my($file) = <STDIN>);

open(INPUTFILE, "<${file}");

while(<INPUTFILE>)
{

    if(/wilma/ && /fred/)
    {
      print "$_\n";
    }

}

