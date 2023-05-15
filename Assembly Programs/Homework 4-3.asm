
; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h


main_loop:
    ; check if key is pressed
    mov ax, 0100h ; check for keystroke in keyboard buffer
    int 16h     ; ZF = 0 if keystroke found
     
    mov ax, 0c00h
    int 21h ; clear keyboard buffer

    jne out_0    ; jumps if ZF = 0

    mov ax, 0001h ; otherwise output '1'
    out 199, ax
    
    jmp main_loop
     
out_0:
    mov ax, 0000h
    out 199, ax
    
    jmp main_loop

ret




