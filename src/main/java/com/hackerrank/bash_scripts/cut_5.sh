#!/bin/bash

#https://www.hackerrank.com/challenges/text-processing-cut-5/problem
while read -r line; do
  echo "$line" | cut -f-3
done
