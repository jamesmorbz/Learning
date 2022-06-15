jr	ra
 move	v0,zero
hlt:
 b	120000950 <hlt>
 nop
_MIPS_STUBS_:
 ld	t9,-32752(gp)
 move	t3,ra
 jalr	t9
 daddiu	t8,zero,12