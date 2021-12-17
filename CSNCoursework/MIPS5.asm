.data
input_file_name: .asciiz "in.ppm"
output_file_name: .asciiz "out.ppm"

.text
main:
# Open the input file for reading the image from:
li   $v0, 13       # system call for open file
la   $a0, input_file_name      # input file name
li   $a1, 0        # flag for reading
li   $a2, 0        # mode is ignored
syscall            # open a file
addu $s0, $zero, $v0      # save the file descriptor

addi $t0, $zero, 1
sll  $t0, $t0, 7
sll  $t0, $t0, 7
addu $t1, $t0, $t0
addu $t0, $t1, $t0
addi $s1, $t0, 61 # In short: $s1 holds 128*128*3+61
sub $s2, $sp, $s1 # $sp (stack pointer register) holds the address of the top of the stack.
                  # so $s2 will point to an address in the memory from which, we can safely
                  # load our image to.

# In short:
# s1: holds the size of the image in bytes (which for our example, is 49,213)
# s2: holds address of the starting byte of the buffer for the image

# reading from file just opened
li   $v0, 14       # system call for reading from file
addu $a0, $zero, $s0      # file descriptor
addu $a1, $zero, $s2   # address of buffer to read to
addu $a2, $zero, $s1  # how many bytes to read
syscall            # read from file

# Close the input file:
li $v0, 16         # system call code for close file
addu $a0, $zero, $s0      # file descriptor to close
syscall            # close file
#

# At this point, we still have:
# s1: holds the size of the image in bytes
# s2: holds the address of the starting byte of the buffer for the image.
#     note that now, the image data is loaded in the memory, byte by byte,
#     starting from this address onwards.


# >>>> MAKE YOUR CHANGES BELOW THIS LINE


addiu    $t0, $s2, 61 # t0: will hold the address of each byte of the image
                      # we have added 61, since this is the size of the header
                      # we will not touch the bytes of the header.
                      # this is fine, as none of the tasks require changing the size 
                      # or format of the image. 

li  $s3, 3 # colours
li  $s4, 128 # columns
li  $s5, 128 # rows

li      $t4, 0 # row counter
Loop_over_rows:
li      $t3, 0 # column counter
Loop_over_pixels_in_each_row: # i.e., columns
li      $t2, 0 # colour counter (each colour represents Red-Green-Blue)
Loop_over_colours_in_each_pixel:
lbu     $t1, 0($t0) # loading the value of the byte, representing
                    # the intensity of the corresponding RGB colour of that pixel
                    # note that an earlier version was using lb, which does sign extension
                    # but the 8-bits of the colour should be interpreted as unsigned 
                    # representing values from 0 to 255. 
# do something with the value of the byte
sb      $t1, 0($t0) #
addi    $t0, $t0, 1 # address of the next byte
addi    $t2, $t2, 1 # counter of the colour bytes for each pixel
bne     $t2, $s3, Loop_over_colours_in_each_pixel
addi    $t3, $t3, 1 # counter over the pixels in a row (column)
bne     $t3, $s4, Loop_over_pixels_in_each_row
addi    $t4, $t4, 1
bne     $t4, $s5, Loop_over_rows


# >>>> MAKE YOUR CHANGES ABOVE THIS LINE


# at this point, still we must have:
# s1: holds the size of the image in bytes
# s2: holds the address of the starting byte of the buffer for the image
# so do not touch the values in s1 and s2 in the part that you edit!

# Open a file for saving the processed image to:
li   $v0, 13       # system call for open file
la   $a0, output_file_name      # input file name
li   $a1, 0x41     # flag for (creating if not exists and) writing 
li   $a2, 0x1B4    # access mode of the file is set to "-rw-r--r--"
syscall            # (create if not exists, and) open the file in writing mode
addu $s0, $zero, $v0      # save the file descriptor to $s0

# saving the processed image to it:
li $v0, 15  # syscall for writing to a file
addu $a0, $zero, $s0 # passing the file descriptor, in $a0
addu $a1, $zero, $s2 # passing the memory address to get the data to save to the file, in $a1
addu $a2, $zero, $s1 # passing how many bytes to save to the file, in $a2
syscall

# Close the output file:
li $v0, 16         # system call code for close file
syscall            # close file

# Finish the programme:
li $v0, 10      # syscall code for exit
syscall         # exit