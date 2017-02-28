#!/usr/bin/perl
use strict;
use warnings;

sub parseParams($);	# prototype subroutine

## Your code here
my $match_accessmodifier = '';
my $match_anyword = '';
my $match_anystring = '';

# open input file and output file
open FILE, "<$ARGV[0]" or die;
open RESULT, ">_$ARGV[0]" or die;

while (<FILE>) 
{
	my $line = $_;
	chomp $line;

	# get whitespace offset
	$line =~ m/^(\s+)/;
	my $ws = $1;
	
	# regex to match a java constructor
	if ($line =~ m/($match_accessmodifier)\s+($match_anyword)\s*\($match_anystring\)/) 
	{
		my ($constructorName, $rawParamList) = ($2, $3);
		my %paramList = &parseParams($rawParamList);

		print RESULT 	
		"$ws/**\n" . 
		"$ws * Constructor Name: $constructorName\n" .
		"$ws * Description:	TODO\n";
		print RESULT "$ws * \@param $_	TODO\n" for (keys %paramList); 
		print RESULT "$ws**/\n" . "$line\n";
	}

	# regex to match a java method 
	elsif ($line =~ m/($match_accessmodifier)\s+(static\s+)?($match_anyword)\s+($match_anyword)\s*\($match_anystring\)/)
	{
		my ($returnType, $methodName, $rawParamList) = ($3, $4, $5);
		my %paramList = &parseParams($rawParamList);

		print RESULT 	
		"$ws/**\n" . 
		"$ws * Method Name: $methodName\n" .
		"$ws * Description:	TODO\n";
		print RESULT "$ws * \@param $_	TODO\n" for (keys %paramList); 
		print RESULT "$ws * \@return	TODO\n" if $returnType ne "void";
		print RESULT "$ws **/\n" . "$line\n";

	}

	# neither method nor constructor, so just print this line
	else {
		print RESULT "$line\n";
	}
}

#####################################################################
## Subroutine:	parseParams
## Description: Takes in a raw string of parameters and 
##		returns a hash of {varName->type} pairs
#####################################################################
sub parseParams($)
{
	my $arg = shift;
	my @paramPairs = split(',', $arg);
	my %paramList;
	
	for (@paramPairs)
	{
		my @pair = split(' ', $_);
		$paramList{$pair[1]} = $pair[0];
	}	

	return %paramList;	# return the hash of {varName -> type}
}
	
