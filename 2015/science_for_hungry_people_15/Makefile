YEAR = 2015
DAY = 15
NAME = science_for_hungry_people
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \
	$(UTIL)/$(LIB)/time.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

$(OUT)/$(NAME).s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		$(UTIL)/$(OUT)/time.jnh \
		$(NAME).jn
	${CATPILE}

include ../../makefile.inc
