YEAR = 2025
DAY = 4
NAME = printing_department
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

$(OUT)/printing_department.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		printing_department.jn
	${CATPILE}

include ../../makefile.inc
