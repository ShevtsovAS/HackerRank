#!/bin/bash

#https://www.hackerrank.com/challenges/bash-tutorials-slice-an-array/problem
declare -a arr
while read -r line; do
  arr+=("$line")
done

result=""
for i in {3..7}; do
  result+="${arr[$i]} "
done

echo "$result"
