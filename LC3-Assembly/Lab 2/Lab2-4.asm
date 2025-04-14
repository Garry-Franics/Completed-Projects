.ORIG x3000

; Initialize variables
LD R1, SIZE ; Load the size of the array
NOT R1, R1 ; Make negative
ADD R1, R1, #1 ; Add 1
AND R2, R2, #0 ; Clear R2, it will be used as an index
LEA R3, ARRAY ; Load the address of the array into R3

LOOP
    ; Get user input
    GETC 
    OUT 
    ; Subtract #16 three times to convert ASCII to integer
    ADD R4, R0, #-16
    ADD R4, R4, #-16
    ADD R4, R4, #-16
    STR R4, R3, #0 ; Store the result in the array
    ADD R3, R3, #1 ; Move to the next location in the array
    ADD R2, R2, #1 ; Increment the index
    ; Check if the loop should continue
    ADD R5, R2, R1 
    BRz DONE
    BR LOOP

DONE    
HALT ; Halt the program

SIZE .FILL #10 ; Size of the array (5-20)
ARRAY .BLKW #20 ; Reserve 20 words for the array

.END