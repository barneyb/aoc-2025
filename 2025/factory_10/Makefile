YEAR = 2025
DAY = 10
NAME = factory
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

$(OUT)/factory.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		factory.jn
	${CATPILE}

include ../../makefile.inc
