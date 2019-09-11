# craftdemo

# To test using curl command:

curl -H "Content-Type: application/json" --data-binary @./image_with_cats.json http://localhost:8080/findTheCats

To test using the test scripts inside bin:

# local
# Use a threshold value inside the script
sh test-local.sh
# Use default threshold at the server (85%)
sh test-local2.sh

# aws
# Use a threshold value inside the script
sh test-aws.sh
# Use default threshold at the server (85%)
sh test-aws2.sh

# The AWS instance currently running the code is at:
3.218.29.81
