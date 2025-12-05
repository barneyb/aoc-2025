YEAR = 2025
DAY = 3
NAME = lobby
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

$(OUT)/lobby.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		lobby.jn
	${CATPILE}

include ../../makefile.inc
