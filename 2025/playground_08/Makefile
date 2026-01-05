YEAR = 2025
DAY = 8
NAME = playground
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \
	$(UTIL)/$(LIB)/get_opts.o \
	$(UTIL)/$(LIB)/Graph.o \
	$(UTIL)/$(LIB)/PQ.o \
	$(UTIL)/$(LIB)/UnionFind.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) -n 10 < ex1.txt

graph: $(PROG) ex1.txt
	$(PROG) -n 10 < ex1.txt

$(OUT)/playground.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		$(UTIL)/$(OUT)/get_opts.jnh \
		$(UTIL)/$(OUT)/Graph.jnh \
		$(UTIL)/$(OUT)/PQ.jnh \
		$(UTIL)/$(OUT)/UnionFind.jnh \
		playground.jn
	${CATPILE}

include ../../makefile.inc
