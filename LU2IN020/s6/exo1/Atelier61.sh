#!/bin/bash
#BERRADA Nacer 28610440

#question 1
cat hosts|sed -En "/localhost$/s/^([0-9]{1,3}(\.[0-9]{1,3}){3}).*/\1/p"

#question 2
lpoptions -l|sed -En "/\*/s/.*(\*[^ ]*).*/\1/p" 

#question 3
ip addr |sed -En "/eth[0-9]\.*[0-9]*$/s/.* ([0-9]{1,3}(\.[0-9]{1,}){3})\/.*(eth[0-9]\.*[0-9]*$)/\3 \1  /p"

#question 4
cat group |sed -En "/$(whoami)/s/([^:]*):.*/\1/p"

#question 5
df |sed -En "s/^[a-zA-Z0-9/]* *[0-9]* *[0-9]* *([0-9]*.*)/\1/p" | sort -nr |sed -En "1s/^.*(\/.*)/ \1 /p"

#question 6
 cat services | sed -En "/\t([0-9]{1,3})\/[a-z]+/p" |sed -En "s/([a-zA-Z-]+) *\t?.*#(.*)/\1  : \2   /p"

