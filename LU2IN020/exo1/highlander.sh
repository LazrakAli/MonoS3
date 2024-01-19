#!/bin/bash

trap 'echo I wont die' SIGINT

while [ 0 ]; do
	echo "il ne doit en rester qu'un"
	sleep 1
done