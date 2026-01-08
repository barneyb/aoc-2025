YEAR = 2025
DAY = 4
NAME = printing_department
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \
	$(UTIL)/$(LIB)/grid_adjacent.o \
	$(UTIL)/$(LIB)/time.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

$(OUT)/printing_department.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		$(UTIL)/$(OUT)/grid_adjacent.jnh \
		$(UTIL)/$(OUT)/time.jnh \
		printing_department.jn
	${CATPILE}

include ../../makefile.inc
