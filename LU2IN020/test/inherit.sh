#!/bin/bash

testFile="test"
rm -f $testFile
trap "touch $testFile" SIGTERM
./inherit-child.sh &
sleep 1
kill -SIGTERM $!
wait
if [ -f $testFile ] ; then
echo "les handlers du père sont hérités par le fils"
else
echo "le fils démarre avec les handlers par défaut"
fi