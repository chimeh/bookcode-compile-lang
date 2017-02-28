#! usr/bin/perl

use strict;
use warnings;

my($line) = 0;

while(defined($line = <>))
{
  chomp($line);
  print "It was $line that I saw!\n";
}
