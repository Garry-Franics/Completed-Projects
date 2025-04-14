#!/bin/bash

echo "Starting this script (hopefully it is executable with chmod a+x ./miner.sh)"

## Prints hash of nonces prefixed to each word in the dictionary
for num in $(seq 1 105); do
  for word in $(cat ../data/dictionary); do
    
    # Combine the number and word
    combo="${num}${word}"
    
    # Get the hash
    hash=$(echo -n "$combo" | sha256sum | awk '{print $1}')
    
    # Check if the hash has a leading zero
    if [[ $hash == 000* ]]; then

      # Print the combination and its hash
      printf "%s - %s\n" "$combo" "$hash"

    fi

  done
done
