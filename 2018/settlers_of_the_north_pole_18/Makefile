YEAR = 2018
DAY = 18
NAME = settlers_of_the_north_pole
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(LIB)/Map.o \

all: $(PROG) input.txt
	$(PROG) < input.txt

ex0: $(PROG) ex0.txt
	$(PROG) < ex0.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

$(OUT)/settlers_of_the_north_pole.s: \
		$(OUT)/allocator.jstd.jnh \
		$(OUT)/ArrayList.jstd.jnh \
		$(OUT)/HashMap.jstd.jnh \
		$(OUT)/io.jstd.jnh \
		$(OUT)/string.jstd.jnh \
		$(OUT)/sys.jstd.jnh \
		$(OUT)/Map.jnh \
		settlers_of_the_north_pole.jn
	${CATPILE}

$(OUT)/Map.s: \
		$(OUT)/allocator.jstd.jnh \
		$(OUT)/io.jstd.jnh \
		$(OUT)/string.jstd.jnh \
		$(OUT)/sys.jstd.jnh \
		$(OUT)/StringBuilder.jstd.jnh \
		Map.jn
	${CATPILE}

include ../../makefile.inc
