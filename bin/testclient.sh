#!/bin/bash

hasThreshold=0

function usage
{
    echo "Usage: $0 [options]"
    echo "Options:"
    echo " -f | --frame: <fileName> (eg. ../data/image_with_cats.txt)"
    echo " -a | --api <apiName> (eg. native or kmp)"
    echo " -t | --threshold <matchPercentage> (eg. 80)"
    echo " -s | --server <serverAddress> (eg. localhost or 3.218.29.81)"
    echo " -h | --help (display usage)"
}

if [ $# -lt 6 ]; then
    printf "Error: inadequate number of arguments\n\n"
    usage
    exit
fi

while [ "$1" != "" ]; do
    case $1 in
        -f | --frame )        		shift
                                        file=$1
                                        ;;
        -a | --api )         		shift
                                        api=$1
                                        ;;
        -t | --threshold )     		shift
                                        threshold=$1
                                        hasThreshold=1
                                        ;;
	-s | --server )			shift
					server=$1
					;;
        -h | --help )                   usage
                                        exit
                                        ;;
         * )                            usage
                                        exit
                                        ;;
    esac
    shift
done


# create a temporary file, and arrange for it to be deleted on exit
tempfile=$(mktemp "${TMPDIR:-/tmp}/curldata.XXXXXX")
trap 'rm -rf "$tempfile"' 0 ERR

frame=$(cat ${file})

if [ -z "${server}" ]; then
    printf "Error: server is not set\n"
    exit
fi

if [ -z "${api}" ]; then
    printf "Error: api is not set\n"
    exit
fi

if [ -z "${file}" ]; then
    printf "Error: frame is not set\n"
    exit
fi


if [ $hasThreshold -gt 0 ]; then
	printf '%s' '{"frame":"'"${frame}"'", "threshold":"'"${threshold}"'"}' >"$tempfile"
else
        printf '%s' '{"frame":"'"${frame}"'"}' >"$tempfile"
fi

curl -s -X POST -H "Content-Type: application/json" --data-binary  "@$tempfile" http://${server}:8080/findTheCats/${api}

