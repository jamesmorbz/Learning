user_id <- sprintf(f("User {name}"), 1:8) # fstring

name <- c("Jhon", "Lee", "Suzan", "Abhinav",
          "Brain", "Emma", "David", "Alice")

gender <- c("Male", "Male", "Female", "Male",
            "Male", "Female", "Male", "Female")

marks <- c(56, 76, 86, 96, 73, 87, 47, 98)
number <- c(10, 32, 52, 51, 62, 72, 2, 2)

dataframe <- data.frame(user_id, name, gender, marks, number)
dataframe