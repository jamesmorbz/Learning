.data
prompt_for_input: .asciiz "Please enter your numbers, pressing enter after each, (0 to terminate):\n"
prompt_for_output: .asciiz "Your quantity of interest is equal to: "

.text
main:
# prompting the user with a message for a string input:
li $v0, 4
la $a0, prompt_for_input
syscall

li  $s0, 0
LOOP: 
li  $v0, 5
syscall 

beq $v0, $zero, Exit
blt		$v0, $zero, negative	# if user input is smaller than check if divisible by 4
nextInstr: 
#add		$s0, $s0, $v0		# $v0 = $t1 + $t2
j LOOP


negative: 
addi	$t0, $zero, 4			
div		$v0, $t0			
mfhi	$t1					# $t1 = v0 mod 4 
beq		$t1, $zero, count
j nextInstr

count: 
addi	$s0, $s0, 1		
j nextInstr


Exit:
# prompting the user with a message for the processed output:
li $v0, 4
la $a0, prompt_for_output
syscall

# printing the output
addiu  $v0, $zero, 1
addu $a0, $zero, $s0
syscall

# Finish the programme:
li $v0, 10      # syscall code for exit
syscall         # exit