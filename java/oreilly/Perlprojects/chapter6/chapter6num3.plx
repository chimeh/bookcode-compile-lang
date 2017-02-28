#. [15] Write a program to list all of the keys and values in %ENV. Print the
#  results in two columns in ASCIIbetical order. For extra credit, arrange the
#  output to vertically align both columns. The length function can help you
#  figure out how wide to make the first column. Once you get the program
#  running, try setting some new envi-ronment variables and ensuring that
#  they show up in your output.

#! usr/bin/perl

use strict;
use warnings;

print "PATH is $ENV{PATH}\n";

my(@keys) = keys %ENV;
my(@values) = values %ENV;
my($key);
my($value);
my($longest);

foreach $key(@keys)
{
  my $key_length = length($key);

  $longest= $key_length if ($key_length > $longest);

}

foreach $key(sort @keys)
{

   printf "%-${longest}s %s\n", $key, $ENV{$key};

}

