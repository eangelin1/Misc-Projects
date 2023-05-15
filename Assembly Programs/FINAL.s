.text
.global _start
_start:
INIT:
// store bit values of numbers for 7seg into memory location 0xffffffe0
MOV R0, #0b00111111// 0
MOV R1, #0b00000110// 1
MOV R2, #0b01011011// 2
MOV R3, #0b01001111// 3
MOV R4, #0b01100110// 4
MOV R5, #0b01101101// 5
MOV R6, #0b01111101// 6
MOV R7, #0b00000111// 7
MOV R8, #0b01111111// 8
MOV R9, #0b01100111// 9
MOV R10, #0xFFFFFFE0
MOV SP, R10
PUSH {R0-R9}
MOV SP, #0

// initial values for thread 2
MOV R0, #0xFFFFFFB8
MOV R1, #1
MOV R2, #10
MOV R7, SP // move sp into r7 = thread2 context
SUB R7, R7, #0x10 // R7 keeps track of store/load location (thread2)
MOV SP, R7 // set sp so write is possible
STM R7, {R0-R2,R8} // store into 0xfffffff0

// initial values for thread 1
MOV R0, #0x100 // initial value for 7seg write data
MOV R1, #1
MOV R2, #6
MOV R8, SP // r8 = thread1 context
SUB R8, R8, #0x10 // R8 keeps track of store/load location (thread1)
MOV SP, R8
STM R8, {R0-R2, R7} // thread1 R7 points to thread2's context
ADD R9, R7, #0x0C
STM R9, {R8}

// i/o addresses
LDR R4, =0xFF200050 // pushbutton for thread switching
LDR R5, =0xFF200020 // 7seg
LDR R6, =0xFF200000

// initialize register for thread1 (default thread)
MOV R3, #0 // current thread

	
		THREAD1:
			// load context: r7 should be pointing to thread2 context
			LDM R8, {R0-R2,R7} // context load
			
			MOV R9, #0x06 // bit values for '1' on 7seg
			LDR R11, [R5] // current values in 7seg
			AND R11, #0xFFFFFF00 // only write to specific 7seg
			ORR R9, R9, R11
			STR R9, [R5] // set 7seg values

		THREAD1_LOOP:
			CMP R1, R2
			BGT THREAD1_INIT
			
			LDR R11, [R5]
			AND R11, #0xFFFF00FF // only write to specific 7seg
			ORR R0, R0, R11
			STR R0, [R5]
			AND R0, R0, #0x0000FF00 // retrieve r8 value for left shift
			LSL R0, R0, #1
			ADD R1, R1, #1
			
			LDR R9, [R4] // load push button value
			CMP R9, #1 // check if button pressed
			BEQ CHANGE_THREAD
			
			B THREAD1_LOOP
			
		THREAD1_INIT:
			MOV R0, #0x100 // reset write data
			MOV R1, #1 // reset loop counter
			B THREAD1_LOOP
			
	
		THREAD2:
			// load context: sp in thread1 context points to thread2 context
			LDM R7, {R0-R2,R8} // context load
			
			MOV R9, #0x5B // bit values for '2' on 7seg
			LDR R11, [R5] // get current 7seg values
			AND R11, #0xFFFFFF00 // only write to specific 7seg
			ORR R9, R9, R11 // R9 contains correct values
			STR R9, [R5] // set 7seg values
			
		THREAD2_LOOP:
			CMP R1, R2
			BGT THREAD2_INIT
			
			MOV SP, R0 // AVOID ERRORS
			LDR R11, [R0] // get digit write data from memory
			LSL R11, #16 // left shift 4 places to keep integrity of other 7segs
			LDR R9, [R5] // current values of 7 seg
			AND R9, #0xFF00FFFF // keep only values of last 2 7seg
			ORR R11, R11, R9 // set correct store value
			STR R11, [R5]
			ADD R0, #4 // next memory location
			ADD R1, R1, #1
			
			LDR R9, [R4] // load push button value
			CMP R9, #1 // check if button pressed
			BEQ CHANGE_THREAD
			
			B THREAD2_LOOP
		
		THREAD2_INIT:
			MOV R0, #0xFFFFFFB8 // reset mem location
			MOV R1, #1 // reset loop counter
			B THREAD2_LOOP



CHANGE_THREAD:
// set thread
CMP R3, #0
BNE SET_THREAD1
// save context
STM R8, {R0-R2}
MOV R3, #1
B RETURN
SET_THREAD1:
// save context
STM R7, {R0-R2}
MOV R3, #0

RETURN:
CMP R3, #0 // check which thread to run
BNE THREAD2
B THREAD1