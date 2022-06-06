#!/bin/bash

#https://www.hackerrank.com/challenges/bash-tutorials-read-in-an-array/problem
declare -a arr
while read -r line; do
  arr+=("$line")
done

echo "${arr[@]}"