## Lab 3 : CEG 3400

### Encryption

Table of contents:
* [Background](LAB3-INSTRUCTIONS.md#background)
* [Objectives](LAB3-INSTRUCTIONS.md#objectives)
* [Preparation](LAB3-INSTRUCTIONS.md#preparation)
* [Task 1: Symmetric Encryption](LAB3-INSTRUCTIONS.md#task-1---symmetric-encryption)
* [Task 2: Asymmetric Encryption](LAB3-INSTRUCTIONS.md#task-2---asymmetric-encryption)
* [Task 3: Encrypted Email](LAB3-INSTRUCTIONS.md#task-3---encrypted-email)
* [Task 4: Digital Signatures](LAB3-INSTRUCTIONS.md#task-4---digital-signatures)

---

#### Background

Encryption is a basic tool for securing data at rest and data being sent across unsecure 
channels.

---

#### Objectives

Become familiar with several symmetric and asymmetric encryption protocols.

Analyze how well some encryption protocols secure data versus others.

---

#### Preparation

These commands will likely need a full version of bash as found in WSL Ubutun or other 
linux distro.  The default shell provided by MobaXTerm does not support several of the 
needed programs.  Be sure you can run all needed commands before getting stuck 
partway through ;)

---

### Task 1 - Symmetric Encryption

In this task you will encrypt a simple image using different encryption modes and analyze the 
effectiveness of each mode.  A list of all the supported algorithms and modes are found in the
`openssl` and `enc` man pages.

![original image](./data/example_pic.bmp)

Encrypt the `data/example_pic.bmp` file with the aes-128 algorithm using each of the following encryption modes 
- `aes-128-cbc`, `aes-128-ecb`, and `aes-128-ofb` – total of 3 ciphertext files created.  Name the files `example_pic.cbc`, 
`example_pic.ecb`, and `example_pic.ofb`.  Make up an easy to remember encryption password when 
prompted (e.g. 12345).

The general form of the encryption command is as follows:

```
openssl  <ALGORITHM_MODE>  -e  -in  <INPUT_FILE>   -out  <OUTPUT_FILE>
```

When you encrypt these images, you also encrypt the header information needed to open them
in an image viewer.
In order to view the encrypted files you will need to recreate the standard header format
of a `.bmp` file before an image viewer will recognize the encrypted data as an image.

The needed header data is stored in the first 54 bytes of every `.bmp` file.  You can cut it out and 
save it with the following command: `dd if=example_pic.bmp of=bmp_header.hex bs=1 count=54`
but I did this already and provided the header data in `data/bmp_header.hex`.

To prepend this to your cypher text simply use the cat command as follows:

```
cat data/bmp_header.hex ./example_pic.ofb > ofb.bmp
```

Once you have done this with all three files open them in an image viewer and compare them to
the original image and each other.  Write your finding in `README.md`

**10 points of your grade are given simply for embedding all three encrypted images in your `README.md`**

---

### Task 2 - Asymmetric Encryption 

This task is brand new this semester!  It's really simple, using the instructor's public
key provided in class, encrypt this file (the `LAB3-INSTRUCTIONS.md` file.).

Name this file `task2.enc`.  Answer all task 2 questions in the `README.md`.

Hints: To *encrypt* a message or file using `gpg` you need to specify a *recipient* email 
address that you have the corresponding public key.  I am intentionally not giving the 
full command so you can play around with `gpg`, you might need to use the `man` command (and/or google).

---

### Task 3 - Encrypted Email

This task is very straightforward.  Send an encrypted email to matthew.kijowski@wright.edu from your campus email address.

```email
To: matthew.kijowski@wright.edu
From: <youremail@wright.edu>

Subject: Task 3 - Thunder

Body: <whatever you would like, only I can read it>
```

* [Download Thunderbird](https://www.thunderbird.net/en-US/)
* Add your Wright State email account to Thunderbird:
  * IMAP settings
    * Server name: `outlook.office365.com`
    * Port: `993`
    * Encryption method: `TLS`
    * Authentication method: `OAuth2`
  * SMTP settings
    * Servername: `smtp.office365.com`
    * Port: `587`
    * Encryption method: `STARTTLS`
    * Authentication method: `OAuth2`
* In Thunderbird settings > End-To-End Encryption 
  * Add your GPG secret key
    * You can retrieve it from `gpg --export-secret-keys <youremail@wright.edu>`
  * Open the `OpenPGP Key Manager` and import my public key (and anyone else's you want to have secure communications with)

---

### Task 4 - Digital Signatures

For this task you will be applying a digital signature to your `README.md` (using the `gpg` command, not thunderbird).  This must be
done AFTER you are done answering all questions (don't edit the `README.md` after signing)
.  If you do need to edit `README.md` after you sign it, simply delete the signature at the end and re sign it.

Hint: There are multiple ways to digitally sign a document with `gpg`.  Use the `--clearsign` option.

