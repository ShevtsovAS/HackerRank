#!/bin/bash

#https://www.hackerrank.com/challenges/text-processing-cut-8/problem
while read -r line; do
  echo "$line" | cut -d ' ' -f-3
done
