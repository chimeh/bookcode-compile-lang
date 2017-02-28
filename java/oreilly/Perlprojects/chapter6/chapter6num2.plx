#2. [15] Write a program that reads a series of words (with one word per line†)
#   until end-of-input, then prints a summary of how many times each word was
#   seen. (Hint: remember that when an undefined value is used as if it were a
#   number, Perl auto-matically converts it to 0. It may help to look back at
#   the earlier exercise that kept a running total.) So, if the input words
#   were fred, barney, fred, dino, wilma, fred (all on separate lines), the
#   output should tell us that fred was seen 3 times. For extra credit, sort
#   the summary words in code point order in the output.

#! usr/bin/perl

use strict;
use warnings;

my(@words);
my($word);
my(%count);

print "\nPlease enter a list of words:\n";
chomp(@words = <STDIN>);

foreach $word(@words)
{

    $count{$word} += 1;

}

foreach $word( sort (keys %count))
{

  print "$word was seen $count{$word} times.\n";

}
