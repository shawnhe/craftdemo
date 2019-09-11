# craftdemo

# To test using curl command:

curl -H "Content-Type: application/json" --data-binary @./image_with_cats.json http://localhost:8080/findTheCats

To test using the test scripts inside bin:

# Use a threshold value inside the script
sh test.sh

or 

# Use default threshold at the server (85%)
sh test2.sh
