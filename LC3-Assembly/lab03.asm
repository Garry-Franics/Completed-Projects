.ORIG x3000
; = = = = = = = = = = = = = = = = =
; MAIN CODE HERE
MAIN
    LEA R0, PROMPT1 ; Loads the first string into R0
    PUTS ; Prints string in R0
    LEA R0, NEWLINE
    PUTS
    JSR GETNUM ; Jumps to GETNUM subroutine
    ST R0, NUM1
    LEA R0, NEWLINE
    PUTS
    LEA R0, PROMPT2 ; Loads the second string into R0
    PUTS
    LEA R0, NEWLINE
    PUTS
    JSR GETOP ; Jumps to GETOP subroutine
    ST R0, MAIN_OP
    LEA R0, NEWLINE
    PUTS
    LEA R0, PROMPT3 ; Loads the third string into R0
    PUTS
    LEA R0, NEWLINE
    PUTS
    JSR GETNUM
    ST R0, NUM2
    LEA R0, NEWLINE
    PUTS
    LD R0, NUM1
    LD R1, NUM2
    LD R2, MAIN_OP
    JSR CALC ; Jumps to CALC subroutine
    ST R0, RESULT
    LEA R0, PROMPT4 ; Loads the fourth string into R0
    PUTS
    LD R0, RESULT
    JSR DISPLAY ; Jumps to DISPLAY subroutine
    LEA R0, NEWLINE
    PUTS
BRnzp MAIN
HALT
; - - - - - - - - - - - - - - - - -
; MAIN VARS
PROMPT1 .STRINGZ "Enter your first number (0-99): "
PROMPT2 .STRINGZ "Enter an opperation (+,-,*): "
PROMPT3 .STRINGZ "Enter your second number (0-99): "
PROMPT4 .STRINGZ "The result is: "
NEWLINE .STRINGZ "\n"
NUM1 .FILL #0
NUM2 .FILL #0
SAVER1 .FILL #1
SAVER2 .FILL #1
SAVER3 .FILL #1
SAVER7 .FILL #1
RESULT .FILL #0
MAIN_OP .FILL #0
; = = = = = = = = = = = = = = = = =

; = = = = = = = = = = = = = = = = =
DISPLAY
; DISPLAY CODE HERE
;SAVE
; - - - - - - - - - - - - - - - - -
ST R1, SAVER1
ST R2, SAVER2
ST R3, SAVER3
ST R7, SAVER7
; - - - - - - - - - - - - - - - - -
; saving arguments into parameters
ST R0, RESULT_DISPLAY
LD R0, RESULT_DISPLAY
BRzp SKIP_NEGATIVE

NOT R0, R0
ADD R0, R0, #1
ST R0, RESULT_DISPLAY
LD R0, HYPHEN
OUT

SKIP_NEGATIVE

; int quotient = 0
AND R0, R0, #0
ST R0, QUOTIENT

STARTDIVIDETHOU
    LD R0, RESULT_DISPLAY
    LD R1, THOUSAND
    NOT R1, R1 ; 2's compliment R1
    ADD R1, R1, #1 ; Makes negative R1
    ADD R0, R0, R1 ; Subtracts R1 from R0
    BRnz ENDDIVIDETHOU
    ; a -= b
    ST R0, RESULT_DISPLAY
    ; Add 1 to quotient
    LD R0, QUOTIENT
    ADD R0, R0, #1
    ST R0, QUOTIENT
    BRnzp STARTDIVIDETHOU
ENDDIVIDETHOU

; load return values
LD R0, QUOTIENT
ADD R0, R0, #15
ADD R0, R0, #15
ADD R0, R0, #15
ADD R0, R0, #3
OUT

AND R0, R0, #0
ST R0, QUOTIENT

STARTDIVIDEHUND
    LD R0, RESULT_DISPLAY
    LD R1, HUNDRED
    NOT R1, R1 ; 2's compliment R1
    ADD R1, R1, #1 ; Makes negative R1
    ADD R0, R0, R1 ; Subtracts R1 from R0
    BRnz ENDDIVIDEHUND
    ; a -= b
    ST R0, RESULT_DISPLAY
    ; Add 1 to quotient
    LD R0, QUOTIENT
    ADD R0, R0, #1
    ST R0, QUOTIENT
    BRnzp STARTDIVIDEHUND
ENDDIVIDEHUND

; load return values
LD R0, QUOTIENT
ADD R0, R0, #15
ADD R0, R0, #15
ADD R0, R0, #15
ADD R0, R0, #3
OUT

AND R0, R0, #0
ST R0, QUOTIENT

STARTDIVIDETEN
    LD R0, RESULT_DISPLAY
    LD R1, TEN
    NOT R1, R1 ; 2's compliment R1
    ADD R1, R1, #1 ; Makes negative R1
    ADD R0, R0, R1 ; Subtracts R1 from R0
    BRnz ENDDIVIDETEN
    ; a -= b
    ST R0, RESULT_DISPLAY
    ; Add 1 to quotient
    LD R0, QUOTIENT
    ADD R0, R0, #1
    ST R0, QUOTIENT
    BRnzp STARTDIVIDETEN
ENDDIVIDETEN

; load return values
LD R0, QUOTIENT
ADD R0, R0, #15
ADD R0, R0, #15
ADD R0, R0, #15
ADD R0, R0, #3
OUT

LD R0, RESULT_DISPLAY
LD R1, 48
ADD R0, R0, R1
OUT
; restore return address
LD R7, SAVER7
RET

; - - - - - - - - - - - - - - - - -
; DISPLAY VARS
QUOTIENT .FILL #0
THOUSAND .FILL #1000
HUNDRED .FILL #100
RESULT_DISPLAY .FILL #0
48 .FILL #48
HYPHEN .FILL x2D
; = = = = = = = = = = = = = = = = =

; = = = = = = = = = = = = = = = = =
GETNUM
; GETNUM CODE HERE
;SAVE
; - - - - - - - - - - - - - - - - -
ST R1, SAVER1
ST R2, SAVER2
ST R3, SAVER3
ST R7, SAVER7
; - - - - - - - - - - - - - - - - -
GETC ; Get a character from the keyboard
OUT
ADD R1, R0, #-16 ; first subtraction
ADD R1, R1, #-16 ; second subtraction
ADD R1, R1, #-16 ; third subtraction
ST R1, DIG1
GETC
OUT
ADD R1, R0, #-16 ; first subtraction
ADD R1, R1, #-16 ; second subtraction
ADD R1, R1, #-16 ; third subtraction
ST R1, DIG2
LD R1, DIG1
LD R3, TEN
AND R2, R2, #0 ; Clear R2 (temporary result)
ADD R5, R3, #0 ; Copy multiplier to R5 (counter)
MULTIPLY2
    BRz DONE2 ; If R5 (counter) is zero, we're done
    ADD R2, R2, R1 ; Add multiplicand to temporary result
    ADD R5, R5, #-1 ; Decrement counter
BRnzp MULTIPLY2 ; Repeat the loop
DONE2
ADD R1, R2, #0
LD R2, DIG2
ADD R0, R1, R2
LD R7, SAVER7
RET
; - - - - - - - - - - - - - - - - -
; GETNUM VARS
DIG1 .FILL #0
DIG2 .FILL #0
TEN .FILL #10
; = = = = = = = = = = = = = = = = =

; = = = = = = = = = = = = = = = = =
GETOP
;GETOP CODE HERE
;SAVE
; - - - - - - - - - - - - - - - - -
ST R1, SAVER1
ST R2, SAVER2
ST R3, SAVER3
ST R7, SAVER7
; - - - - - - - - - - - - - - - - -
AND R2, R2, #0
GETC
OUT
ADD R2, R0, #0 ; move to R2
ST R2, OP
LD R0, OP
LD R7, SAVER7
RET
; - - - - - - - - - - - - - - - - -
; GETOP VARS
OP .FILL #0
; = = = = = = = = = = = = = = = = =

; = = = = = = = = = = = = = = = = =
CALC
; CALC CODE HERE
;SAVE
; - - - - - - - - - - - - - - - - -
ST R1, SAVER1
ST R2, SAVER2
ST R3, SAVER3
ST R7, SAVER7

ADD R3, R1, #0
ADD R1, R0, #0
; - - - - - - - - - - - - - - - - -
ADD R0, R2, #-16 ; checks if R2 has a +
ADD R0, R0, #-16
ADD R0, R0, #-11
BRz ADDITION
ADD R0, R2, #-16 ; chekcs if R2 has a -
ADD R0, R0, #-16
ADD R0, R0, #-13
BRz SUBTRACTION
ADD R0, R2, #-16 ; chekcs if R2 has a *
ADD R0, R0, #-16
ADD R0, R0, #-10
BRz MULTIPLICATION

ADDITION
;LD R1, SAVER1
;LD R3, SAVER3
ADD R1, R1, R3
BRnzp ESCAPE

SUBTRACTION
;LD R1, SAVER1
;LD R3, SAVER3
NOT R3, R3
ADD R3, R3, #1
ADD R1, R1, R3
BRnzp ESCAPE

MULTIPLICATION
;LD R1, SAVER1
;LD R3, SAVER3
AND R2, R2, #0 ; Clear R2 (temporary result)
ADD R5, R3, #0 ; Copy multiplier to R5 (counter)
MULTIPLY
    BRz DONE ; If R5 (counter) is zero, we're done
    ADD R2, R2, R1 ; Add multiplicand to temporary result
    ADD R5, R5, #-1 ; Decrement counter
BRnzp MULTIPLY ; Repeat the loop
DONE
ADD R1, R2, #0      ; Store the result back in R1
ESCAPE
ST R1, NUM3
LD R0, NUM3
LD R7, SAVER7
RET
; - - - - - - - - - - - - - - - - -
; CALC VARS
NUM3 .FILL #0
; = = = = = = = = = = = = = = = = =

.END