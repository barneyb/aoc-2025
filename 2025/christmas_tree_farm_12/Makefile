YEAR = 2025
DAY = 12
NAME = christmas_tree_farm
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

$(OUT)/christmas_tree_farm.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		christmas_tree_farm.jn
	${CATPILE}

include ../../makefile.inc
