# set cannot have duplicates
# Output: {1, 2, 3, 4}
set = {1, 2, 3, 4, 3, 2}
print(set)

# we can make set from a list
# Output: {1, 2, 3}
set = set([1, 2, 3, 2])
print(set)

# set cannot have mutable items
# here [3, 4] is a mutable list
# this will cause an error.

set = {1, 2, [3, 4]}

# to create an empty set we do this

a = set()

# instead of creating an empty dictionary which is this

b = {}

