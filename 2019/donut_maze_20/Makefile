YEAR = 2019
DAY = 20
NAME = donut_maze
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(UTIL)/$(LIB)/get_opts.o \
	$(UTIL)/$(LIB)/Graph.o \
	$(UTIL)/$(LIB)/graph_to_dot.o \
	$(LIB)/parse.o \
	$(LIB)/Portal.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

clean_internal:
	rm -f *.dot *.dot.svg

graph: ex1.$(GRAPHVIZ_LAYOUT).svg
	mv ex1.$(GRAPHVIZ_LAYOUT).svg graph.dot.svg

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

ex2: $(PROG) ex2.txt
	$(PROG) --no-part-two < ex2.txt

ex3: $(PROG) ex3.txt
	$(PROG) < ex3.txt

$(OUT)/donut_maze.s: \
		$(OUT)/allocator.jstd.jnh \
		$(OUT)/ArrayList.jstd.jnh \
		$(UTIL)/$(OUT)/get_opts.jnh \
		$(UTIL)/$(OUT)/Graph.jnh \
		$(UTIL)/$(OUT)/graph_to_dot.jnh \
		$(OUT)/HashMap.jstd.jnh \
		$(OUT)/io.jstd.jnh \
		$(OUT)/parse.jnh \
		$(OUT)/Portal.jnh \
		$(OUT)/Queue.jstd.jnh \
		donut_maze.jn
	${CATPILE}

$(OUT)/parse.s: \
		$(OUT)/allocator.jstd.jnh \
		$(OUT)/ArrayList.jstd.jnh \
		$(OUT)/HashMap.jstd.jnh \
		$(OUT)/io.jstd.jnh \
		$(OUT)/Portal.jnh \
		$(OUT)/string.jstd.jnh \
		$(OUT)/sys.jstd.jnh \
		$(OUT)/donut_maze.jnh \
		parse.jn
	${CATPILE}

$(OUT)/Portal.s: \
		$(OUT)/allocator.jstd.jnh \
		Portal.jn
	${CATPILE}

include ../../makefile.inc
