#!/bin/bash

# this file is ONLY provided as a reference for how mkijowski
# strips the UID and W# from orig data and create finitlname secret ID
# Only to be run by mkijowski and referenced by students for lab1

TMPF=/tmp/secrets-removed.csv

rm $TMPF

cp $1 $TMPF

awk -F "," '{print $1}' $TMPF | cut -c 1 > finit
awk -F "," '{print $2}' $TMPF > lname

cat -n finit > finitnl && rm finit
cat -n lname > lnamenl && rm lname

join --nocheck-order finitnl lnamenl > secret && rm finitnl lnamenl

awk '{print $2$3","}' secret > secrets && rm secret

cat -n secrets > finitlnamenl && rm secrets
cat $TMPF | cut -d "," -f3- > datascrub
cat -n datascrub > datascrubnl && rm datascrub

join --nocheck-order finitlnamenl datascrubnl > shiny.csv
cat shiny.csv | sed 's/^[0-9]\+[[:blank:]]//g' > reallyshiny.csv && rm shiny.csv

rm $TMPF finitlnamenl datascrubnl

