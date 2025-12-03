YEAR = 2025
DAY = 2
NAME = gift_shop
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \
	$(LIB)/read.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

ex2: $(PROG) ex2.txt
	$(PROG) < ex2.txt

$(OUT)/gift_shop.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		$(OUT)/read.jnh \
		gift_shop.jn
	${CATPILE}

include ../../makefile.inc
