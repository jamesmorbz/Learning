function1 <- function(fname) {
  paste(fname, "Griffin")
}

function1("Peter")
function1("Lois")
function1("Stewie")

function2 <- function(fname, lname) {
  paste(fname, lname)
}

function2("Chris", "Griffin")
function2("Meg", "Griffin")

function3 <- function(country = "England") {
  paste("I am from", country)
}

function3() # will get the default value, which is England
function3("USA")