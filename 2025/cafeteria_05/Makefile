YEAR = 2025
DAY = 5
NAME = cafeteria
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

$(OUT)/cafeteria.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		cafeteria.jn
	${CATPILE}

include ../../makefile.inc
