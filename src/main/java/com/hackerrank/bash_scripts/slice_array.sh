#!/bin/bash

#https://www.hackerrank.com/challenges/bash-tutorials-slice-an-array/problem
declare -a arr
while read -r line; do
  arr+=("$line")
done

echo "${arr[@]}" | cut -f3-7 -d ' '
