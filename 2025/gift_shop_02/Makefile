YEAR = 2025
DAY = 2
NAME = gift_shop
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \
	$(UTIL)/$(LIB)/read.o \
	$(UTIL)/$(LIB)/string.o \
	$(LIB)/Range.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

ex2: $(PROG) ex2.txt
	$(PROG) < ex2.txt

$(OUT)/gift_shop.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		$(UTIL)/$(OUT)/read.jnh \
		$(UTIL)/$(OUT)/string.jnh \
		$(OUT)/Range.jnh \
		gift_shop.jn
	${CATPILE}

include ../../makefile.inc
