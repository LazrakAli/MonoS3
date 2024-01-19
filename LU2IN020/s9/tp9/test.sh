#!/bin/bash

dd if=/dev/urandom of=/tmp/iss bs=1b count=5000000 &
pid=$(pgrep -n dd)
sleep 1
kill -SIGUSR1 $pid
wait $pid
rm -f /tmp/iss
