#!/bin/bash

frame=$(cat ../config/frame.blob)

curl -X POST -H "Content-Type: application/json" --data-binary '{"frame":"'"${frame}"'", "threshold":"75"}' http://localhost:8080/findTheCats

