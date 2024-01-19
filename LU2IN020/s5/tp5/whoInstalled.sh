#!/bin/bash

cat /etc/passwd | grep '1000' | cut -d: -f1
