.ORIG x3000

; Load x and y from memory
LD R0, X_VAL
LD R1, Y_VAL
AND R2, R2, #0
ADD R2, R2, #1

; Check if y is 0
BRz END

; Loop to calculate z = x^y
MULT_LOOP    
    ADD R3, R2, #0
    AND R2, R2, #0
    ADD R4, R0, #0

LOOP
    ADD R2, R2, R3
    ADD R4, R4, #-1
    BRp LOOP
    ADD R1, R1, #-1
    BRp MULT_LOOP

END     
    STI R2, RESULT
    HALT

; Data section
X_VAL   .FILL x0002
Y_VAL   .FILL x0003
RESULT  .FILL x8000

.END