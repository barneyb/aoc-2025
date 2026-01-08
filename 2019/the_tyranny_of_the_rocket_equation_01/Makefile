YEAR = 2019
DAY = 1
NAME = the_tyranny_of_the_rocket_equation
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \
	$(UTIL)/$(LIB)/time.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

$(OUT)/the_tyranny_of_the_rocket_equation.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		$(UTIL)/$(OUT)/time.jnh \
		the_tyranny_of_the_rocket_equation.jn
	${CATPILE}

include ../../makefile.inc
