addiu   $s0, $zero, -1 
addiu   $s1, $zero, -2 
addiu   $s2, $zero, 3 
addiu   $s3, $zero, -3 
 
subu    $t0, $s0, $s2 
subu    $t1, $s1, $s3 
subu    $t2, $s1, $s2 
subu    $t3, $s0, $s3 
subu    $t4, $s2, $s2 
subu    $t5, $s3, $s3 
 
addiu $v0, $zero, 10 # to Exit the program 
syscall # Exit