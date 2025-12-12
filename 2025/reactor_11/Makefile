YEAR = 2025
DAY = 11
NAME = reactor
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

$(OUT)/reactor.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		reactor.jn
	${CATPILE}

include ../../makefile.inc
