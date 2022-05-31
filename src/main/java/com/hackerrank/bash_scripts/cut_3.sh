#!/bin/bash

#https://www.hackerrank.com/challenges/text-processing-cut-3/problem
while read -r line; do
  echo "$line" | cut -c2-7
done
