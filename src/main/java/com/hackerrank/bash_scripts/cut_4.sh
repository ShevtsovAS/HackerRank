#!/bin/bash

#https://www.hackerrank.com/challenges/text-processing-cut-4/problem
while read -r line; do
  echo "$line" | cut -c-4
done
