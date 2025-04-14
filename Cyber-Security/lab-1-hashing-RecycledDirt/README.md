[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/SLc4hyUA)
# Lab 1 : CEG 3400 Intro to Cyber Security

## Name: Garry Francis

### Task 1: Hashing

**Reminder Deliverable:** Is your `salted-data.csv` in this repository?

Answer the following in this file:

* How many unique users are in the data?

There are 43 unique users listed in `quiz_data.csv`.

* How many salts did you create?

I have 43 salts created because we use the same salted hash for all instances of a user.

* How many possible combinations will I need to try to figure out the secret ID
  of all students (assume I know all potential secret IDs and have your 
  `salted-data.csv`)

Users X Salts = Combinations.

43 X 43 = 1,849 Combinations.

* Instead of salts, if you were to use a nonce (unique number for each hashed
  field) how many possible combinations would I need to try?

Fields X Nonces = Combinations.

There are 1,303 fields which would each have their own nonce.

1,303 X 1,303 = 1,697,809 Combinations.

* Given the above, if this quiz data were *actual* class data, say for example
  your final exam, how would you store this dataset?  Why?

I would probably store it with nonces because that is almost 10 times the possible combinations there are just using salts.

```bash
cat quiz_data.csv | awk -F ',' '{ print $1}' | sort | uniq # command that lists the unique users in quiz_data.csv

salt=$(tr -dc 'A-Za-z0-9' < /dev/urandom | head -c 5) # line that makes a random salt for each user

salted_hash=$(printf "%s" "$salted_user" | sha256sum | awk '{print $1}') # hashes the salted user
```

---

### Task 2: Crypto Mining

**Reminder Deliverable:** Is your "mining" code in this repository (`mining/`)?
**Reminder Deliverable:** Is your nonce + word combos in `coins.txt`?

Answer the following:

* Paste your ***nonce+word(s) and hash(s)*** below ( either 3x `000` hashes or 1x `0000`
hash)

```
45insert - 000ef02bbdc2e8e7e226b9f1f0562dfc081d8f3424c0faa4678e798cf308b25e
47random - 000866962f9aab9772d29e2eb15a065ee70230d99e15202127d7a403a882e427
76bottle - 000372934dcc795cf667e79f216eceed7a3fc1e14826204cf17ae8ac31dea356
96bottle - 000851c7d6364695e13582f4cb4c724557b6e43ee18b5aa21c6430abe45298ed
```

* How many words were in your dictionary?

I have 72 words in my dictionary.

* How many nonces did your code iterate over?

1 through 105 so 105 nonces.

* What was the maximum number of hashes your code *could* compute given the above?

72 X 105 = 7560

* What did you think about Task 2?

Is this actually what crypto is? I was going to ask how there was value in long zero chains but then I remembered real money is just paper and metal. So I guess my real question is HOW MANY zeros we need before it starts becoming something valuable? 100? 500?

* Is there a better way than brute force to attempt to get higher valued coins?

Okay well this depends on what we're calling "brute force". Is adding more numbers to itterate over (like going from 1 to 500 on every word) brute force? I guess if you could figure out how the hashing algorith makes a hash with leading zeros you could write specific coins that would be more likely to generate zero chains but that still kinda sounds like brute forcing it? So I guess not?

* Why or why not?

Yeah I wrote it all above.

```bash
if [[ $hash == 000* ]]; then
  printf "%s - %s\n" "$combo" "$hash"
  fi

# makes it so that only hashes with at least three leading zeros get printed so I dont have to go digging for them
```
