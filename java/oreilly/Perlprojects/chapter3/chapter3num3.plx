#3. [8] Write a program that reads a list of strings (on separate lines)
#   until end-of-input. Then it should print the strings in code point order.
#   That is, if you enter the strings fred, barney, wilma, betty, the output
#   should show barney betty fred wilma. Are all of the strings on one line in
#   the output or on separate lines? Could you make the output appear in either
#   style?

#! usr/bin/perl

print "Please enter a list of words, enter Ctrl + D when finished:\n";

chomp(@words = <STDIN>);

print "Original list:\n";

foreach $word(@words)
{
  print $word, " ";
}
print "\n\n";

print "Sorted list (ascending):\n";

chomp(@sorted = sort(@words));

foreach $word(@sorted)
{
  print $word , " ";
}
print "\n\n";

