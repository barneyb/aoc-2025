YEAR = 2025
DAY = 9
NAME = movie_theater
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

$(OUT)/movie_theater.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		movie_theater.jn
	${CATPILE}

include ../../makefile.inc
