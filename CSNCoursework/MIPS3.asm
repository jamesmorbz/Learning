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


blt		$v0, $zero, modulus	# if user input is smaller than zero change to positive 
nextInstr: 
add		$s0, $s0, $v0		# $v0 = $t1 + $t2


beq $v0, $zero, Exit
j LOOP


modulus: 
sub		$v0, $zero, $v0	# positive number = 0-( negative number) 
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