.global _start
_start:
	
ldr r0, =0xFF200020 // r0 is base address of 7-seg display
ldr r1, =0xFF200050 // r1 is base address of push button 0
mov r2, #0b00000110 // r2 is hex for displaying '1' on 7-seg
mov r3, #0b00111111 // r3 is hex for displaying '0' on 7-seg


idle:
	mov r4, #0x1
	ldr r5, [r1]
	ands r5, r4
	bne button_press
	str r2, [r0]        // display '1'
	b idle

button_press:
	str r3, [r0]		// display 0
	b idle