YEAR = 2025
DAY = 7
NAME = laboratories
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

$(OUT)/laboratories.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		laboratories.jn
	${CATPILE}

include ../../makefile.inc
