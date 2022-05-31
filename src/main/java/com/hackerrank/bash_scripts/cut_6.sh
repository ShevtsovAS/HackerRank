#!/bin/bash

#https://www.hackerrank.com/challenges/text-processing-cut-6/problem
while read -r line; do
  echo "$line" | cut -c13-
done
