YEAR = 2025
DAY = 9
NAME = movie_theater
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \
	$(UTIL)/$(LIB)/get_opts.o \
	$(UTIL)/$(LIB)/Svg.o \
	$(UTIL)/$(LIB)/time.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) --no-part-b < ex1.txt

floor.a.svg, floor.b.svg: $(PROG) input.txt
	$(PROG) --svg --no-part-b < input.txt > floor.a.svg
	$(PROG) --svg             < input.txt > floor.b.svg

$(OUT)/movie_theater.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		$(UTIL)/$(OUT)/get_opts.jnh \
		$(UTIL)/$(OUT)/Svg.jnh \
		$(UTIL)/$(OUT)/time.jnh \
		movie_theater.jn
	${CATPILE}

include ../../makefile.inc
