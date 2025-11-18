YEAR = 2019
DAY = 20
NAME = donut_maze
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(LIB)/parse.o

all: $(PROG) input.txt
	$(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

$(OUT)/donut_maze.s: \
		$(OUT)/allocator.jstd.jnh \
		$(OUT)/HashMap.jstd.jnh \
		$(OUT)/parse.jnh \
		donut_maze.jn
	${CATPILE}

$(OUT)/parse.s: \
		$(OUT)/allocator.jstd.jnh \
		$(OUT)/ArrayList.jstd.jnh \
		$(OUT)/HashMap.jstd.jnh \
		$(OUT)/io.jstd.jnh \
		$(OUT)/string.jstd.jnh \
		$(OUT)/sys.jstd.jnh \
		$(OUT)/donut_maze.jnh \
		parse.jn
	${CATPILE}

include ../../makefile.inc
