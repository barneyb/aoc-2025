YEAR=2015
DAY=19
NAME = medicine_for_rudolph
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \
	$(UTIL)/$(LIB)/time.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG)
	$(PROG) < example_1.txt

ex2: $(PROG)
	$(PROG) < example_2.txt

$(OUT)/$(NAME).s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		$(UTIL)/$(OUT)/time.jnh \
		$(NAME).jn
	${CATPILE}

include ../../makefile.inc
