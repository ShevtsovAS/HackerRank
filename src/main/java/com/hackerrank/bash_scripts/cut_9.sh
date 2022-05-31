#!/bin/bash

#https://www.hackerrank.com/challenges/text-processing-cut-9/problem
while read -r line; do
  echo "$line" | cut -f2-
done
