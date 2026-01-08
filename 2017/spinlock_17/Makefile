YEAR = 2017
DAY = 17
NAME = spinlock
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \
	$(UTIL)/$(LIB)/time.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG)
	echo 3 | $(PROG)

$(OUT)/$(NAME).s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		$(UTIL)/$(OUT)/time.jnh \
		$(NAME).jn
	${CATPILE}

include ../../makefile.inc
