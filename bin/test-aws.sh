#!/bin/bash

frame=$(cat ../config/frame.blob)

curl -s -X POST -H "Content-Type: application/json" --data-binary '{"frame":"'"${frame}"'", "threshold":"50"}' http://3.218.29.81:8080/findTheCats/kmp

