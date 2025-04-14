.ORIG x3000

; Initialize registers
LD R0, MAX_ITERATIONS ; Load maximum iterations into R0
AND R1, R1, #0
AND R3, R3, #0

LOOP
    ADD R3, R3, #5
    ADD R1, R1, #1
    ; Check if loop counter reached maximum iterations
    LD R2, MAX_ITERATIONS
    NOT R2, R2
    ADD R2, R2, #1
    ADD R4, R1, R2
    BRz END_LOOP
    BR LOOP

END_LOOP
    STI R3, RESULT ; Store the result (R3) into memory address x8001
    HALT ; Halt the program

; Data section
MAX_ITERATIONS .FILL #10 ; Maximum iterations (change as needed)
RESULT .FILL x8001 ; Memory location to store the result

.END