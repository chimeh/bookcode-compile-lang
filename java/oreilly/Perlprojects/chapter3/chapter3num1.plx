#1. [6] Write a program that reads a list of strings on separate lines
#   until end-of-input and prints out the list in reverse order.
#   If the input comes from the keyboard, you’ll probably need to signal
#   the end of the input by pressing Control-D on Unix, or Control-Z on
#   Windows.

#! usr/bin/perl
print "=============\n";
print "List Reversal\n";
print "=============\n\n";

print "Please enter a list of words (enter Ctrl+D when finished):\n";

@words = <STDIN>;
chomp(@words);

print "\nOriginal list:\n";

foreach $word(@words)
{
  print $word , " ";
}

print "\n";

print "\nReversed list:\n";

@revwords = reverse(@words);
foreach $word(@revwords)
{
  print $word , " ";
}

print "\n\n";

