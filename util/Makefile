include ../make_vars.inc
OBJECTS = \
	$(LIB)/aocd.o \
	$(LIB)/get_opts.o \
	$(LIB)/Graph.o \
	$(LIB)/graph_to_dot.o \
	$(LIB)/grid_adjacent.o \
	$(LIB)/Pt.o \
	$(LIB)/SortedMap.o \
	$(LIB)/string.o \
	$(LIB)/time.o \

all: $(OBJECTS)

$(LIB)/time.o:
	gcc -c time.c -o $(LIB)/time.o

$(OUT)/aocd.s: \
		$(OUT)/time.jnh \
		aocd.jn
	${CATPILE}

$(OUT)/graph_to_dot.s: \
		$(OUT)/Graph.jnh \
		graph_to_dot.jn
	${CATPILE}

$(OUT)/SortedMap.s: \
		$(OUT)/string.jnh \
		SortedMap.jn
	${CATPILE}

include ../makefile.inc
