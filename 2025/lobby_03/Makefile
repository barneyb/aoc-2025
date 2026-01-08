YEAR = 2025
DAY = 3
NAME = lobby
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \
	$(UTIL)/$(LIB)/time.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

$(OUT)/lobby.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		$(UTIL)/$(OUT)/time.jnh \
		lobby.jn
	${CATPILE}

include ../../makefile.inc
