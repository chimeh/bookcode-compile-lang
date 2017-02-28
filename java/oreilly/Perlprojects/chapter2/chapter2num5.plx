#! usr/bin/perl

print "Please enter a word or a letter: ";
$word1 = <STDIN>;
print "\n";

print "Please enter a number: ";
$num2 = <STDIN>;
print "\n";

$count = 0;

while($count < $num2)
{
  print  "", ($count+1),". letter/word is: ", $word1;
  $count++;
}
