#1. [7] Write a program that will ask the user for a given name and report the
#   corre-sponding family name. Use the names of people you know, or (if you
#   spend so much time on the computer that you don’t know any actual people)
#   use the following table:

#! usr/bin/perl

use strict;
use warnings;

print "\nPlease enter the name of the person you are looking for:\n";

chomp(my($firstname) = <>);

my($key) = undef;

my(%hash) = ( Fred   => 'Flintstone',
    Barney => 'Rubble',
    Wilma => 'Flintstone',
    Betty => 'Rubble',
    );
foreach $key(keys %hash)
{
  if($key eq $firstname)
  {
    print $key , "'s lastname is ", ($hash{$key} , ".\n\n");
  }
}

