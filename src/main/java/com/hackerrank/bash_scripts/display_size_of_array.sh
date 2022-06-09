#!/bin/bash

#https://www.hackerrank.com/challenges/bash-tutorials-display-the-third-element-of-an-array/problem
mapfile -t arr
echo "${#arr[@]}"
