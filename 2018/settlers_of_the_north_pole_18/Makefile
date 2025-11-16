YEAR = 2018
DAY = 18
NAME = settlers_of_the_north_pole
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \

all: $(PROG) input.txt
	$(PROG) < input.txt

$(OUT)/settlers_of_the_north_pole.s: \
		$(OUT)/allocator.jstd.jnh \
		$(OUT)/io.jstd.jnh \
		settlers_of_the_north_pole.jn
	${CATPILE}

include ../../makefile.inc
