YEAR = 2016
DAY = 16
NAME = dragon_checksum
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \

all: $(PROG) input.txt
	time $(PROG) 272 < input.txt
	time $(PROG) 35651584 < input.txt

ex1: $(PROG)
	$(PROG) 2 1
	$(PROG) 2 0
	$(PROG) 6 11111
	$(PROG) 13 111100001010
	$(PROG) 20 10000

$(OUT)/$(NAME).s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		$(NAME).jn
	${CATPILE}

include ../../makefile.inc

verify:
	time $(PROG) 272 < input.txt | ../../verify.sh $(YEAR) $(DAY)
	time $(PROG) 35651584 < input.txt | ../../verify.sh $(YEAR) $(DAY)
