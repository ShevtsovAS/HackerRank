#!/bin/bash

#https://www.hackerrank.com/challenges/bash-tutorials-concatenate-an-array-with-itself/problem
mapfile -t arr <<<"$(cat)"
result=("${arr[@]}" "${arr[@]}" "${arr[@]}")
echo "${result[@]}"
