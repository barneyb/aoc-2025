include ../make_vars.inc
OBJECTS = \
	$(LIB)/get_opts.o \
	$(LIB)/Graph.o \
	$(LIB)/graph_to_dot.o \

all: $(OBJECTS)

$(OUT)/get_opts.s: \
		$(OUT)/allocator.jstd.jnh \
		$(OUT)/HashMap.jstd.jnh \
		$(OUT)/string.jstd.jnh \
		get_opts.jn
	${CATPILE}

$(OUT)/Graph.s: \
		$(OUT)/allocator.jstd.jnh \
		$(OUT)/ArrayList.jstd.jnh \
		$(OUT)/HashMap.jstd.jnh \
		Graph.jn
	${CATPILE}

$(OUT)/graph_to_dot.s: \
		$(OUT)/ArrayList.jstd.jnh \
		$(OUT)/HashMap.jstd.jnh \
		$(OUT)/Queue.jstd.jnh \
		$(OUT)/io.jstd.jnh \
		$(OUT)/Graph.jnh \
		graph_to_dot.jn
	${CATPILE}

include ../makefile.inc
