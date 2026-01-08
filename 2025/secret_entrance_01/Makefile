YEAR = 2025
DAY = 1
NAME = secret_entrance
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \
	$(UTIL)/$(LIB)/time.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

ex2: $(PROG) ex2.txt
	$(PROG) < ex2.txt

$(OUT)/secret_entrance.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		$(UTIL)/$(OUT)/time.jnh \
		secret_entrance.jn
	${CATPILE}

include ../../makefile.inc
