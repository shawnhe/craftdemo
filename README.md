# craftdemo

# To build the application
on the command line, run: mvn install

# To run the application locally
java -jar target/demo-rest-service-0.1.0.jar

# The AWS instance currently running the code is at:
3.218.29.81

# REST API 
# brutal force
http://3.218.29.81:8080/findTheCats/native
# kmp
http://3.218.29.81:8080/findTheCats/kmp

# To test using curl command:

curl -H "Content-Type: application/json" --data-binary @./image_with_cats.json http://localhost:8080/findTheCats/native

curl -H "Content-Type: application/json" --data-binary @./image_with_cats.json http://localhost:8080/findTheCats/kmp

# To test using the test script inside bin:
Usage: ./testclient.sh [options]

Options:

 -f | --frame: <fileName> (eg. ../config/image_with_cats.txt)

 -a | --api <apiName> (eg. native or kmp)
 
 -t | --threshold <matchPercentage> (eg. 80)
 
 -s | --server <serverAddress> (eg. localhost or 3.218.29.81)
 
 -h | --help (display usage)


