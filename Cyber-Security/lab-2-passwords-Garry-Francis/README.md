[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/n1GyJ1sn)
# CEG 3400 - Lab 2 - Password cracking

Name: 

---

## Task 1 - Simple dictionary attacks

Using a simple dictionary attack and the 500 password wordlist, use the `hashcat` and or `john` to attack both the `sha512.hashes` and `yescrypt.hashes` password lists.  

***Please include the 'hashcat' or 'john' potfile in this repository and answer the following.

* Describe what a basic dictionary attack against a salted/hashed password list is.  Be verbose and explain its top strengths and weaknesses as you see them.

A dictionary attack is a method to crack passwords by trying every word in a predefined list. It works well against weak passwords but struggles with salted and hashed passwords.

Attack Process:

1. Access Hashed Passwords: The attacker needs the database of hashed passwords.
2. Generate Hashes: Combines each dictionary word with the salt (if known) and hashes it.
3. Compare Hashes: Compares generated hashes to stored hashes for matches.

Strengths:

- Efficiency: Faster than brute-force attacks on common passwords.
- Targets Weak Passwords: Many users choose easily guessable passwords.
- Automation: Can quickly test many passwords using scripts.

Weaknesses:

- Salted Hashes: Unique salts complicate cracking multiple accounts.
- Strong Passwords: Complex passwords not in the dictionary are safe.
- Limited Dictionary: Success depends on the dictionary’s content.

In summary, while effective against weak passwords, dictionary attacks face significant challenges with salted and hashed methods.

* How many sha512 hashed passwords were you able to crack with the `500_passwords.txt`?

I was able to crack 24 sha512 passwords

$6$f8lvvnii$Zq1oEfYixhTaiS8W6BGGnU2.3UZWhxw2Y4UvVgAQdBzN42oMmVbnbfkxOQNPt1v4.kbYDeNG/hfv4iQF7iKBJ1:password
$6$lqx9Hy.GlhL3D8xx$FvkFRZ0B/70zJxvLQefcF7J.v6ghcR1MLKgvAOCEtsIU8wqo4nWDWk4.A5kJI4Y74TXSvzZWFyhQsSWsx.u9u1:12345
$6$IzFchSYltRvpJYSc$5551hdvjpF2LrxYBXX078AbAJNHUbMG.1spdOZLgbtsFBCFV.Yuy45030YC.ltp8rQTXf8DSwIPzlqW2GfAo90:password
$6$PlGecK/o$y8OFHRBJe97H1iw7WzGhI.AS8ve7vs1zdeJZFRuDuZMDhA.3ErBQ6tkkcA1XcVKmp.SloE06Q9hxyFaUbveVt.:password
$6$7HXAxDUQNO.ocghW$Ni0x5kPFXs.KRYaCMnog4BjSaLuQOBTDH4GrDnpvtQrlIPQpUI.5eVKJ/rhwOLnPFpbRTvyXWldU.7WJGRwTC1:pass
$6$Bx7JzDCLX6Pdp3tu$rDNuityKBfPwkaDOYMK2qnDfrDDVbN93a.2FbQONHCekYWfsa6gTo36L5jTXKfLReCwkYezRuvBo5BzKNYG6g/:cheese
$6$yo3q9UJCPu5xiZCN$mo4P3AKPViy2mz2OdW0.joXlkg7vELJj5aRZzaAFeZmUWxrWbEQa7.cl5wqCE8JOC2XRjREFUGuJCsrUDxIY4/:12345
$6$iTUu/aBlPMZ4p5Wl$yR1RN1pviu0QzW5yqm4g2Mfo.CllrP3pajIF3.TAHb4n6H6N80KRSOuJf7jd.Tz41Pyq3TAvA/rfwiGZhGy.a.:password
$6$ErwzStgb$46XPUOedyjuNg2ThRRonMW0DrqTxqZtpkAE3MVG80E4FhOI8dFqfVp0incPKxlQhmx6shk59trdjGDBFEK/gY1:password
$6$wSXBMAKMuxULM1dC$cPVWM8fI1K47.dOv6bIkhhntD/GUK4wvDaqrpV1kSNYC9ZeY4H1gktvBKZNSMThH5vNIl9LomxoYvXM3mwRRw/:12345
$6$1Xc/9U.cGg8kxtiC$L1Rk6kWkwh06JXxqHpi5GxfI00oubdbX5kM5OxpY50unI5Za/k1O4hOTiQgdVCMu/eyTBcdWQKjsiasrj8N.Q.:123456
$6$Ldm3VAeB6p1vZax2$VRYFc1i6bxhCGKcAKJwXAvFkD4mxH7YZcqK4h/4ou5ZeC6GQE7c/f1jmZ0vjvuu3as/B7Jt/oH2FL8VZHujmQ.:12345
$6$2gyyBNXhzF9eqPnj$oyHAFWC8NY4.GIqucyfI0ynk2eY6RiOCS88Yd2y.QlPTxKmQk.KUKt.rpLPgPg9bUH9qeJAcI6ImeSvW8Pdmc0:12345
$6$b2i7FWpk$exma69Zf1tfnSYbJCJxzK27LpZBkMuo8qPGmMdCAsGBtzfRF0fmQiu/n664U/gLQeGP7KH9muwEJnisp89ti8/:12345678
$6$vEWIa0NL$insEzECqsYBIKMdsfbEjRlzpRSR5JQxatDop8tC.7IWXbeUE/pE3KyYZTy0DV2c2SGGdxZOLgOve3a4e7Izc10:letmein
$6$O3fvRdCu$zzIjv0he5/DTymRT4Us0zvkXXye6obCRuCfyKETPVzui91MIr3KGvx6k9ao.sOxCbxmqbxRswGvMvQ8o9tz5N0:password
$6$bUF1qmmmDGonX.0X$HAbExdm5WZRTGaI07361koWvhDTR8MThaC6hJJLQ7O3oIER7VLrbVUIvd99FnW72QBW61W/vXH6Jp.FbMGyBH/:password
$6$XHtJ6FTu9K1tIn1H$7JzZ.eVhmiku/PiD7Nz0F1dNiDc0U2asYb15WRD2.dOQYotgULczOxFsUF5BJ1yvDUNqntGW9I8bRPdlUyPDE.:12345
$6$ym0uV.otwn8ZIl0X$EtlCRSBBAf06JptkncddyiFi.KyVBVxXqFT6b7aiaUvdsDrynXiPZ.DDzo1znnaii8buVFw3J257t5opfMtXD0:1234
$6$DnE8uInn$4uH4SVVsFIJXKOPSuIQpNHm88tpSoHqPDxZuRI36ErVWHGo0jPf25yhZExw9ar1qu/tJUt9LUS7iG/C19C5Dv1:password
$6$Z1iP/wW4F6.o8OQQ$tbAl77uth.VDPfuZn2wIuoEhposLIpP7xNZYcpvFZx4rmRw6wxHv4IXYH0QuIvFiwi8NyoRHIu85VcFwTqwBj1:hello
$6$Ei/ZkNBWV5XV/JFD$ZL7acjU1f5NN0C7jEe8zPjTp9iXI7KSHoxV687sBvLQWOi6a6gSKWSyj92V.pFHRt/PuYV9rroLRCGJs8J4Kk.:sailorm00n
$6$hZ.WmkCS$AQTJnj3kS8TV/XcwcMg6HsA9PTapve0hcREK13RuJDUckdUiyjmOheh2VU/v9vWEQiiQrKGMzneCTRDOoB4jh1:apple
$6$/.ArVUCJuA3mCzLG$umH.VBXQkSNMGhwhHC1EFQM/vOmg32jkl32olvDNmTNSo4/5ndxWz4O7Ph5SY9/LevXKNqseXQC3KTxumYwuS/:stupid

* How many yescrypt hashed passwords were you able to crack with the `500_passwords.txt`?

I was able to crack 24 yescrypt passwords

$y$j9T$YeFZQsAxNwiG57sQSUU4B1$lCBSQgHjuPdYeddglE5je5M/U5Rs7fRjzfH.G5OadZD:12345
$y$j9T$KqT53Xy4P0LtcNmfQgfXR.$GIu8/EAqymOa0hXpn7lGK7DFdRD7mzCFICQrUBmxE17:1234
$y$j9T$A.VJI13PbDsiX1.2E9wQp.$Alfvz70a7BNMTy46KgjeiHtnngbTFZmi6uB.dUJgYEC:1234
$y$j9T$TXVsyVDmqeSReJsSr4qhG/$ltB4YZPsKZn8N/Y0tfUjF/zDAlUbIIav.WFaz2Re9o3:shadow
$y$j9T$jX7xbHhESj0gA5qOVjfKI.$mkzQaKYvuzUsLWVST2IORgDZ17LvIZk2uL/FbvAJWM5:password
$y$j9T$CZYCkcUOR/6zg/Iz6MShg1$BbvfVsvxnIpc3AYN16Km7GQ7KZnx2MbcDZitgD11ou/:password
$y$j9T$df1UbS5Ix7FWtrJTqRKKt.$b7x5aC/y1usuY5dk0VK/LOhIjNtTHbBE418e3W4xse6:password
$y$j9T$CO.bx4QQm70Mo1J54ebPu1$Ms6pv/nSbqP4GrT./DM8oct6Bx4EozWEkuKVk1mN1c7:dragon
$y$j9T$ivWDE4zw7MLfDsNvLm.SD.$A8.sa39GwdUl3GOY0qf4YffXDN0pSK96y3q7PRLj8W4:qwerty
$y$j9T$u9l7yyWV/cWBbrYMS5Bq2.$oV8KWdFpkotFD1SlYavrplwKtNZ/kyfw0MxqBic99T4:12345
$y$j9T$FY6ji3SsFE7AWR7dbtqnd0$SJNfAzLi8/C/AKAQJIlvmJY7HCAh/uRxiQjsjoIowN3:123456
$y$j9T$Pn0wd9FW2i7R9RK4q5tej0$rXVpbWRMTSlx.H./LrMqaOhF3AgIukihYdfGuWO7aJ1:123456
$y$j9T$gChg.okHCljiQ1n7SuIhn1$x5GP7Q/ImKCT0R4jpt6ioo4p2E/Gk7KNlFuqa0Wds2.:monkey
$y$j9T$xeEQFj8/gUP3I.MAg5.3w.$ZSBWCVilfWJYcMF5gOz6j8nOGfuGiQQa2RM3FsGvw92:dragon
$y$j9T$g2yWmJat4Mhg3mvPIfmbI1$bdGX6Qr5.vQLExU2FB7A2xmAVanaDiEVKSDQQynQuq4:hello
$y$j9T$lt/D8DjUO78lIAJ7dy3Li1$c.Nnkp.GPGm2uNUmdEz4HrJlrBHglJVTgHsblaequn/:hello
$y$j9T$LEzz9W2k0ouRqadGLASKn0$tY/LlPSSWoxV8PZHe9zdW4Ez9Zmom4fEHhBK5arsP36:banana
$y$j9T$5ceMoB3l4YVY/UymrsdgY0$2OJL.LrA51etczKIRuYsWKQhYgwzcWi8pjfE/upo0a7:hello
$y$j9T$SI9vBERkBODBaLMtz9a5t1$jshvXJKENkcbxpNQqFr2TNO4EQ/VlnICJLXqtAuapd/:fish
$y$j9T$lrE1u9wvK4AVDYHs7jSmb.$z7e4o58i07yO46WvE8o6ivmGkDMFs.N17flect6uLGB:princess
$y$j9T$a8FUiavVP2TBd/u0ROhHV0$BkFgMyu4V8z9td26D.cec/g2xVIucgsM.n5d6.PlIyD:house
$y$j9T$g2zKb7LeHYRx8JoII9daZ1$Mw.t8g7iUbfHCePdj5FwXIYAhIBj90SRKIpPvypJR56:apples
$y$j9T$HMzIEo7adLgWAmrB/OJi70$dano1eZje/CmkMOD10.sjNT/ybmDIZ32hZ3EOE7Rf27:apple
$y$j9T$Gux4784g4FOjTDtz00Qbz.$CKYkg40UZU5mJnaUD7oFieYgAZeDgi4GraHtK8j2Rd.:apple

* Describe what would be needed to crack all hashes in the `/data/*.hashes` files.  Be verbose!

You would need the original passwords in the dictionary for the attack to work (obviously). So to crack all of the hashes you would need to keep adding common passwords into the dictionary until there is you finally manage to get them all. You could try using premade dictionaries like RockYou, but in the end if the password isn't in your dicionary there is nothing you can do.

* How many total hashes would be computed while performing the above attacks?  Assume the following:
  * simple dictionary attack
  * using 500 password dictionary
  * attack **both** hash lists

Total Hashes Computed = Number of Passwords in Dictionary x Number of Hashes to Crack

111 sha512 + 140 yescrypt = 251 hashes

500 x 251 = 125,500 hashes computed

---

## Task 2 - Go Beyond Limits (Choose your own adventure)

Choose ***one*** of the following tasks and document your progress ***well***.

1. Crack one `sha512.hashes` or `yescrypt.hashes` hash with `500_passwords.txt` using a rule based attack (must be a password not found in task 1 or 2 above).
2. Crack one `sha512.hases` or `yescrypt.hashes` hash with `rockyou.txt` that was not found in task 1 or 2 above (this one is known to be possible within the time limit)
   * `rockyou.txt` can be downloaded with: `wget https://github.com/mkijowski/passwords/raw/master/dictionaries/rockyou.txt.gz`
   * Do ***NOT*** include `rockyou.txt` or `rockyou.txt.gz` anywhere in this repository.  I will deduct many points for doing so...

For whichever you chose write a report below documenting the following:

* Which task you chose.
* Your research (relevant links) and an overview of your testing.
* Details of your final successful attempt (both the command used and estimate of time taken). 
* A ***good*** estimate of the total number of hashes computed to complete this task.
* Both parts of task 2 crack a hash that was not previously found in task 1.  Give a detailed description of how and why it was not found previously and what your attack did differently. 
* Analasys of all passwords cracked (and uncracked), counts, trends, etc.

---

## Task 2 report can go here


I chose task one because `rockyou.txt` scares me (multiple day computation) and I don't want to deal with it. I looked and found a "[John the Ripper Cheat Sheet](https://github.com/C4rbo/john-the-ripper---cheatsheet?tab=readme-ov-file#additional-options)" that showed how to use the `--rules` option. After running the command `john --wordlist=/home/dirt/3400/lab-2-passwords-RecycledDirt/dictionaries/500_passwords.txt --rules --format=crypt /home/dirt/3400/lab-2-passwords-RecycledDirt/data/sha512.hashes` John began to attack the sha512 hashes using the wordlist rules. It took about 30 seconds to find the password "$6$M5A7kaFHQcvG9AGO$azFLDwcBwR8wXN6Cs6FWi13Offv92ykDL5Z51cXE9dO0xu0d9odUgXiM9dOsNgEgEwwArrLlp427FXfVTDROg1:Password" using rule 3, which is to capitalise every alphanumeric word. This wasn't found the first time because the dictionary doesn't contain the word Password capitalised and was only found when rule 3 capitalised the word. Given that password (all lowercase) is the second entry in the dictionary, it was rule 3 when the password was found, there are 111 sha512 hashes, and there are 500 dictionary enteries (500 x 111 x 3 + 1) it took 166,501 computed hashes to find this password. In total I cracked 49 passwords leaving 202 uncracked. The most common passwords were 1234(5), password, hello, and apple. Some passwords used only once were shadow, princess, letmein, and sailorm00n. 

---

## Bonus points (20 lab points)

My testing shows using `hashcat` with `rockyou.txt` takes between 10 and 20 days to run on an Intel core i7 
processor (17 days 10 hours by my last attempt).  Finish a run before this lab is due. 

Submit a `BONUS.md` file with a count of how many passwords and a brief writeup of how you accomplished this task.
You may work in a team of 3 students on the bonus (and only the bonus).  Each student needs to submit their own 
writeup and potfile with all found passwords. 

