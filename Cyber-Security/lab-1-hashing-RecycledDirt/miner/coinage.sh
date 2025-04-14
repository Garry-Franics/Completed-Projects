#!/bin/bash

# All this does is puts the nonced words into `coins.txt`

echo "Starting this script"

# Output file
output_file="../coins.txt"

# Clear the output file if it exists
> "$output_file"

## Prints combinations of nonces prefixed to each word in the dictionary
for num in $(seq 1 105); do
  for word in $(cat ../data/dictionary); do

    # Combine the number and word
    combo="${num}${word}"

    # Print the combination to the output file
    echo "$combo" >> "$output_file"

  done
done

echo "All combinations have been written to $output_file"
