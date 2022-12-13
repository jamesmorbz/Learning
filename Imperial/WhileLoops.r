i <- 1
while (i < 6) {
  print(i)
  i <- i + 1
}

i <- 1
while (i < 6) {
  print(i)
  i <- i + 1
  if (i == 4) {
    break
  }
}

i <- 0
while (i < 6) {
  i <- i + 1
  if (i == 3) {
    next # same as continue is python. Just move onto next iteration of the loop
  }
  print(i)
}