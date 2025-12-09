YEAR = 2025
DAY = 8
NAME = playground
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

$(OUT)/playground.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		playground.jn
	${CATPILE}

include ../../makefile.inc
