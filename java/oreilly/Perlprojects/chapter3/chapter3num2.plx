#2. [12] Write a program that reads a list of numbers (on separate lines)
#   until end-of-input and then prints for each number the corresponding
#   person’s name from the list shown below. (Hardcode this list of names
#   into your program. That is, it should appear in your program’s source
#   code.) For example, if the input numbers were 1, 2, 4, and 2, the output
#   names would be fred, betty, dino, and betty:

#! usr/bin/perl

print "\n Name list\n ---------\n";
print " 1. Squall\n";
print " 2. Zell\n";
print " 3. Irvine\n";
print " 4. Rinoa\n";
print " 5. Quistis\n";
print " 6. Selphie\n";
print " 7. Bahamut\n";
print " 8. Eden\n";
print " 9. Biggs\n";
print " 10. Wedge\n\n";


print "Please enter the list number(s) of the name(s) you wish to print\n";
print "Enter Ctrl+D when finished:\n";

@names = qw(Squall Zell Irvine Rinoa Quistis Selphie Bahamut Eden Biggs Wedge);

@list = <STDIN>;
chomp(@list);

foreach $number(@list)
{
  print @names[$number-1] , " ";
}
print "\n";
