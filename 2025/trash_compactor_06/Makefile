YEAR = 2025
DAY = 6
NAME = trash_compactor
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

$(OUT)/trash_compactor.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		trash_compactor.jn
	${CATPILE}

include ../../makefile.inc
