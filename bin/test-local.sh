#!/bin/bash

frame=$(cat ../config/frame.blob)

curl -s -X POST -H "Content-Type: application/json" --data-binary '{"frame":"'"${frame}"'", "threshold":"45"}' http://localhost:8080/findTheCats/kmp

