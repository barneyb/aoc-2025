YEAR = 2019
DAY = 20
NAME = donut_maze
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(LIB)/parse.o \
	$(LIB)/Portal.o \

all: $(PROG) input.txt
	$(PROG) < input.txt

graph: $(PROG) ex3.txt
	$(PROG) --graph < ex3.txt > graph.dot
	dot -O -Tsvg graph.dot

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

ex2: $(PROG) ex2.txt
	$(PROG) < ex2.txt

ex3: $(PROG) ex3.txt
	$(PROG) < ex3.txt

$(OUT)/donut_maze.s: \
		$(OUT)/allocator.jstd.jnh \
		$(OUT)/ArrayList.jstd.jnh \
		$(OUT)/HashMap.jstd.jnh \
		$(OUT)/io.jstd.jnh \
		$(OUT)/parse.jnh \
		$(OUT)/Portal.jnh \
		$(OUT)/Queue.jstd.jnh \
		$(OUT)/string.jstd.jnh \
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
