#!/bin/bash

trap 'echo I will never die muhahahaha' {1..31}
# trap 'echo I will never die muhahahaha' $(kill -l | tr -s ' \t' '\n' | grep SIG | tr '\n' ' ')

while [ 0 ]; do
	echo "il ne doit en rester qu'un"
	sleep 1
done
