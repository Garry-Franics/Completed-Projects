.ORIG x3000

; #~#~#~#~#~#~#~#~#
; =-=-=-=-=-=-=-=-=
; INITIALIZER CODE
; # DO NOT TOUCH #
; - - - - - - - - -
LD R6, STACK_PTR ; load stack pointer
LEA R4, STATIC_STORAGE ; load global vars pointer
ADD R5, R6, #0 ; set frame pointer
; current stack pointer is sitting on main's return slot
; there are no arguments to our main function
JSR MAIN
HALT
; SETUP VARS
STACK_PTR .FILL x6000
STATIC_STORAGE
; - - - - - - - - -
; PUT .FILL GLOBALS HERE
.FILL #48
.FILL #-48
.FILL #-10
PROMPT1 .STRINGZ "Enter a number: "
PROMPT2 .STRINGZ "F("
PROMPT3 .STRINGZ ") = "
NEWLINE .STRINGZ "\n"
; - - - - - - - - -
; INITIALIZER OVER
; =-=-=-=-=-=-=-=-=
; #~#~#~#~#~#~#~#~#



; #~#~#~#~#~#~#~#~#
; =-=-=-=-=-=-=-=-=
MAIN;(void)

; push return address
ADD R6, R6, #-1
STR R7, R6, #0

; push previous frame pointer
ADD R6, R6, #-1
STR R5, R6, #0

; set current frame pointer
ADD R5, R6, #0

; allocate local variables
; - - - - - - - - -
; #-1: the input
; #-2: result
; #-3: quotient
; - - - - - - - - -
ADD R6, R6, #-3 ; create 3 spaces on the stack (uninitialized)
; =-=-=-=-=-=-=-=-=
LEA R0, PROMPT1
PUTS

GETC
OUT
LDR	R1,	R4,	#1 ; load -48 into R1 for subtraction
ADD R0, R0, R1 ; the thing where we subtract 48 from the input to make it mathable (idr what the real term is)
STR R0, R5, #-1 ; Store the input on the stack

LEA R0, NEWLINE
PUTS

; push input
LDR R0, R5, #-1
ADD R6, R6, #-1
STR R0, R6, #0

; push return slot
ADD R6, R6, #-1

; call
JSR FIBONACCI

; get and store return value
LDR R0, R6, #0
STR R0, R5, #2

; pop return slot and input
ADD R6, R6, #2

LEA R0, PROMPT2
PUTS
LDR R0, R5, #-1
LDR R1, R4, #0
ADD R0, R0, R1
OUT
LEA R0, PROMPT3
PUTS

;TWO DIGIT DISPLAY CAPIBILITY
LDR R0, R5, #2

DIV_LOOP
    LDR R1, R4, #2
    ADD R0, R0, R1
    BRnz END_DIV
    STR R0, R5, #-2
    LDR R0, R5, #-3
    ADD R0, R0, #1
    STR R0, R5, #-3
    LDR R0, R5, #-2
    BRnzp DIV_LOOP
END_DIV

LDR R0, R5, #-3
ADD R0, R0, #-1
BRn ONE_DIG

LDR R0, R5, #-3
LDR R1, R4, #0
ADD R0, R0, R1
OUT

LDR R0, R5, #-2
LDR R1, R4, #0
ADD R0, R0, R1,
OUT
BRnzp SKIP

ONE_DIG
LDR R0, R5, #2
LDR R1, R4, #0
ADD R0, R0, R1
OUT

SKIP

; =-=-=-=-=-=-=-=-=
; deallocate local variables
ADD R6, R6, #3

; restore and pop previous frame pointer
LDR R5, R6, #0
ADD R6, R6, #1

; restore and pop return address
LDR R7, R6, #0
ADD R6, R6, #1


; return to caller
RET
; =-=-=-=-=-=-=-=-=
; #~#~#~#~#~#~#~#~#

FIBONACCI

; push return address
ADD R6, R6, #-1
STR R7, R6, #0

; push previous frame pointer
ADD R6, R6, #-1
STR R5, R6, #0

; set current frame pointer
ADD R5, R6, #0

; allocate local variables
; - - - - - - - - -
;#-1: The other result
; - - - - - - - - -
ADD R6, R6, #-1 ; create 1 space on the stack (uninitialized)
; =-=-=-=-=-=-=-=-=

AND R0, R0, #0
AND R1, R1, #0
LDR R0, R5, #3
BRz ZERO
ADD R0, R0, #-1
BRz ONE
AND R0, R0, #0
AND R1, R1, #0
;ELSE
LDR R0, R5, #3
ADD R0, R0, #-1
ADD R6, R6, #-1
STR R0, R6, #0
ADD R6, R6, #-1
JSR FIBONACCI
LDR R0, R6, #0
STR R0, R5, #-1
ADD R6, R6, #2

LDR R0, R5, #3
ADD R0, R0, #-2
ADD R6, R6, #-1
STR R0, R6, #0
ADD R6, R6, #-1
JSR FIBONACCI
LDR R0, R6, #0
ADD R6, R6, #2

LDR R1, R5, #-1
ADD R0, R0, R1
STR R0, R5, #2
BRnzp LAST

ZERO
STR R0, R5, #2
BRnzp LAST

ONE
ADD R0, R0, #1
STR R0, R5, #2
BRnzp LAST

LAST
; =-=-=-=-=-=-=-=-=
; deallocate local variables
ADD R6, R6, #1

; restore and pop previous frame pointer
LDR R5, R6, #0
ADD R6, R6, #1

; restore and pop return address
LDR R7, R6, #0
ADD R6, R6, #1

RET


.END
