YEAR = 2019
DAY = 20
NAME = donut_maze
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \

all: $(PROG) input.txt
	$(PROG) < input.txt

$(OUT)/donut_maze.s: \
		$(OUT)/allocator.jstd.jnh \
		$(OUT)/io.jstd.jnh \
		donut_maze.jn
	${CATPILE}

include ../../makefile.inc
