## Lab 1 : CEG 3400

### Cryptography

Table of contents:
* [Background](https://github.com/mkijowski/lab1-ceg-3400/blob/master/LAB1.md#background)
* [Objectives](https://github.com/mkijowski/lab1-ceg-3400/blob/master/LAB1.md#objectives)
* [Preparation](https://github.com/mkijowski/lab1-ceg-3400/blob/master/LAB1.md#preparation)
* [Task 1: Hashing](https://github.com/mkijowski/lab1-ceg-3400/blob/master/LAB1.md#task-1-hashing)
* [Task 2: Crypto Mine](https://github.com/mkijowski/lab1-ceg-3400/blob/master/LAB1.md#task-2-crypto-mine)

---

#### Background

Cryptographic hashing is a fundamental tool in our arsenal.  Using it properly can help to 
ensure the Confidentiality and Integrity of our data; however, if used improperly it might 
as well not be used at all.

---

#### Objectives

Students should become familiar with the following:

* hashing
* salt
* nonce

---

#### Preparation

This should be a simple lab that only requires some basic Bash scripting, so all
you should need is access to Bash.

I have provided helpful bash hints and tips but it is up to you to fully
implement the requirements.

If you find a method OTHER than Bash to perform any of these tasks document it
in `README.md`!

##### Required software

* git
* cat
* sha256sum
* awk
* grep
* sed

---

### Task 1: Hashing

In class we discussed hashing a single column in a table of data to preserve
privacy, but as we demonstrated a simple hash does little to preserve a students
privacy if we know a little about the what identifier might be being used.

I have provided the [`quiz_data.csv`](/data/quiz_data.csv) with all hashes
removed.  Provide a unique 5 character/digit  salt for each user and using `printf` and `sha256sum`
replace each secret identifier with a salted hashed value (include the salt as
the first 5 characters of your hash!).  Store this file in
the root of your repository with the name `salted-data.csv` and answer the
related questions in `README.md`.

Example:  If a line of the file begins with the following:

```
MKijowski, 1,1/11/2024 9:33 AM,1/11/2024 9:34 AM,,1,MC, ...<rest of line removed>...
```

Then you need to perform the following:

1. Generate a salt for `MKijowski`, for example `12345`
2. Prepend the salt to the name: `12345MKijowski`
3. Hash the above: `printf 12345MKijowski | sha256sum` which becomes `0fcd00c7c47494fd11cb7e6bf79d6392ae59c81ddded146498736a3ea2ef54a1`
4. Prepend the salt *again* to the resulting hash: `123450fcd00c7c47494fd11cb7e6bf79d6392ae59c81ddded146498736a3ea2ef54a1`
5. Store the value from number 4 above in the original csv for all occurences of `MKijowski`

```
123450fcd00c7c47494fd11cb7e6bf79d6392ae59c81ddded146498736a3ea2ef54a1, 1,1/11/2024 9:33 AM,1/11/2024 9:34 AM,,1,MC, ...<rest of line removed>...
```

BONUS (+1 quiz point): nonce and hash the secret ID (5 digit nonce) of each line, store the nonce beside the hash like above.  Name the file `nonce-data.csv`.

Hints:
* here is some sample code

```bash
cat quiz_data.csv | awk -F ',' '{ print $1}'
```
* `.csv` files can be imported to and exported from excel or other spreadsheet
  application
* you can manually check a hash with `printf 1234MKijowski | sha256sum`


---

### Task 2: Crypto Mine

My local cyber security hero Farmer Joe (fictional) created his own
cryptocurrency named Kentucky Fried Crypto (no relation to the restauraunt).

To earn KFC Coins you simply need to hash a nonce and a word from an english
dictionary (typically `/usr/share/dict/american-english`, I have also provided a
simple dictionary you can expand on in `data/dictionary`) using `sha256sum` and
look for a number of leading `0`s.  More `0`s == more points.  

For example:`printf "4Beasley's" | sha256sum` gives a hash of
`00086d4b4f3d736a7dae792feb96377be57d8812ac0ae1e34d51d0f9eaf7a8b7` which would
be considered a 3 "point" coin since it begins with three `0`'s.  

Some rules:

* nonces can be 2 to 10 digits (positive integers only)
* words must come from an english dictionary and may include punctuation such as
  `'`
* **you may NOT submit any of the example nonce/word combos!**

---
Submit your mining code in the `/miner` folder.  Submit nonce+word combos to the 
`coins.txt` file for **ONLY ONE** of the following:

* 3 different `000` point hashes with their respective nonce and word. For
  example:
  
  ```
  000c25558b4ac04450987eafd6bcf754572ef6ece08556b55e79f0a10d10d2ad  - 23Australopithecus's
  000bfea597d0613077be94766a963ad8e8c11fc2aafd92fe770dcf5e19619315  - 54Australian
  000e86ecc2b23dd1baff4044ed0780fffd83495933b168606f07ff7b60281d31  - 101Accenture
  ```

OR

* A single `0000` point hash (because their worth more) with its respective
  nonce and word.  For example:
  
  ```
  00003704b9de4d3f71e9581f3501c041e690fc99c9f98e151c1f2f4978545893  - 75Bridgeport's
  ```
---

**Attention**  For grading purposes, put your nonce and word combos in the `coins.txt` file WIHTOUT the hash, one per line like so:

Example `coins.txt` file:

```
75Bridgeport's
23Australopithecus's
54Australian
```

Hint 1: you can output all of the words in a dictionary using a for loop in bash like so

```bash
for i in $(cat data/dictionary); do
  printf $i
done
```

BONUS (+1 quiz point): Submit a `00000` (5) point hash.


Be sure to asnwer all the question in `README.md`!

