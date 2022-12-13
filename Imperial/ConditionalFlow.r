10 > 9    # TRUE because 10 is greater than 9
10 == 9   # FALSE because 10 is not equal to 9
10 < 9    # FALSE because 10 is greater than 9
10 != 9   # TRUE because 10 is not equal to 9
# There is also >= and <= for greater or equal to
a <- 23
b <- 62

a > b

if (b > a) {
  print("b is greater than a")
} else if (a == b) {
  print("a and b are equal")
} else {
  print("a is greater than b")
}

thislist <- list("apple", "banana", "cherry")

if ("apple" %in% thislist) {
    print("apple is in the list")
}