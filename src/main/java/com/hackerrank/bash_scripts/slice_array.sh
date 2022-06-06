#!/bin/bash

#https://www.hackerrank.com/challenges/bash-tutorials-slice-an-array/problem
mapfile -t arr <<< "$(cat)"
echo "${arr[@]:3:5}"
