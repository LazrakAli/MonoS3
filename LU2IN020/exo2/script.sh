#!/bin/bash

dd if=/dev/urandom of=/tmp/iss bs=1b count=5000000 &
pid=$(pgrep )

sleep 1
kill -s SIGUSR1 $pid
wait $pid
rm /tmp/iss
