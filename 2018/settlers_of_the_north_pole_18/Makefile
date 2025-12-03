YEAR = 2018
DAY = 18
NAME = settlers_of_the_north_pole
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \
	$(LIB)/Map.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex0: $(PROG) ex0.txt
	$(PROG) < ex0.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

$(OUT)/settlers_of_the_north_pole.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		$(OUT)/Map.jnh \
		settlers_of_the_north_pole.jn
	${CATPILE}

include ../../makefile.inc
