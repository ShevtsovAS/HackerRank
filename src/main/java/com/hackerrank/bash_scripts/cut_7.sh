#!/bin/bash

#https://www.hackerrank.com/challenges/text-processing-cut-7/problem
while read -r line; do
  echo "$line" | cut -d ' ' -f4
done
