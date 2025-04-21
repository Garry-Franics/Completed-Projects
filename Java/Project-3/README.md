# Scrambled Words Game

This program randomly selects a seven letter word with all unique letters from `words.txt` and then scrambles that word. You then have to make other words using those letters. This keeps going until you type `bye`. A four letter word is worth one point while 5+ letter words are worth their length in points. You can also type `mix` to shuffle the order of the letters, and `ls` to see what words you have already entered.

**Example**

[a, e, d, f, n, c, i]
Score: 0
mix
[a, d, f, c, e, i, n]
Score: 0
nice
Score: 1
fence
Score: 6
ls
[nice, fence]
Score: 6
finance
Score: 13
financed
Score: 21
mix
[n, f, c, i, d, e, a]
Score: 21
cicada
ls
[nice, fence, finance, financed]
Score: 21
bye
