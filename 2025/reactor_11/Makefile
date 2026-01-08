YEAR = 2025
DAY = 11
NAME = reactor
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/aocd.o \
	$(UTIL)/$(LIB)/get_opts.o \
	$(UTIL)/$(LIB)/Graph.o \
	$(UTIL)/$(LIB)/graph_to_dot.o \
	$(UTIL)/$(LIB)/time.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) --part-a < ex1.txt

ex2: $(PROG) ex2.txt
	$(PROG) --part-b < ex2.txt

graph: ex1.$(GRAPHVIZ_LAYOUT).svg
	mv ex1.$(GRAPHVIZ_LAYOUT).svg graph.dot.svg

$(OUT)/reactor.s: \
		$(UTIL)/$(OUT)/aocd.jnh \
		$(UTIL)/$(OUT)/get_opts.jnh \
		$(UTIL)/$(OUT)/Graph.jnh \
		$(UTIL)/$(OUT)/graph_to_dot.jnh \
		$(UTIL)/$(OUT)/time.jnh \
		reactor.jn
	${CATPILE}

include ../../makefile.inc
