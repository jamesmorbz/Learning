A = {1,2,3}
B = {2,3,4,5}
s = 0
for k in B:
    for j in A | B:
        s=s+1
print(s)

