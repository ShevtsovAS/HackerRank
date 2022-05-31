#!/bin/bash

#https://www.hackerrank.com/challenges/text-processing-cut-1/problem
while read -r line; do
  echo "$line" | cut -c3
done
