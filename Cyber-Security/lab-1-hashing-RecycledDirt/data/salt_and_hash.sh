#!/bin/bash

# Input and output file names
input_file="quiz_data.csv"
output_file="../salted-data.csv"  # Output file one directory up

# Declare an associative array to store salts for each unique user
declare -A salts

# Create or clear the output file
> "$output_file"

# Read the input file line by line
{
    # Read the (header) and write it to the output file unmodified
    read -r header
    printf "%s\n" "$header" >> "$output_file"

    # Process the rest of the lines
    while IFS= read -r line; do
        # Extract the user
        user=$(printf "%s" "$line" | cut -d',' -f1)
        
        # Check if we have already generated a salt for this user
        if [[ -z "${salts[$user]}" ]]; then
            # Generate a random 5 character salt
            salt=$(tr -dc 'A-Za-z0-9' < /dev/urandom | head -c 5)
            salts[$user]=$salt
        else
            salt=${salts[$user]}
        fi

        # Create the salted user
        salted_user="$salt$user"

        # Hash the salted user with sha256sum
        salted_hash=$(printf "%s" "$salted_user" | sha256sum | awk '{print $1}')

        # Prepend the salt to the hash
        final_value="$salt$salted_hash"

        # Replace the user in the original line with the final hashed value
        modified_line=$(printf "%s" "$line" | sed "s/^$user/$final_value/")

        # Write the modified line to the output file
        printf "%s\n" "$modified_line" >> "$output_file"
    done
} < "$input_file"

printf "Processing complete. Output saved to %s.\n" "$output_file"
