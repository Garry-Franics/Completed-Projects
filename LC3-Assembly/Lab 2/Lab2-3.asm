.ORIG x3000 ; Starting address of the program

; Load the values from memory into R0 and R1
LD R0, VALUE1 
LD R1, VALUE2

; Compare R0 and R1
NOT R2, R1 ; R2 = NOT R1
ADD R2, R2, #1 ; R2 = -R1 (Two's complement)
ADD R2, R2, R0 ; R2 = R0 - R1
BRz EQUAL ; If R2 is zero, branch to EQUAL

; If R0 ≠ R1
ADD R3, R3, #-5    
BR STORE

EQUAL
; If R0 = R1
ADD R3, R3, #5 

STORE
; Store the result in memory address x8002
STI R3, RESULT

HALT

; Memory values to be filled
VALUE1 .FILL x0003  ; Example value for R0
VALUE2 .FILL x0003  ; Example value for R1 (change to test)

RESULT .FILL x8002  ; Memory address to store the result

.END