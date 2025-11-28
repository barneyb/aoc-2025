include ../make_vars.inc
OBJECTS = \
	$(LIB)/get_opts.o \
	$(LIB)/Graph.o \
	$(LIB)/graph_to_dot.o \

all: $(OBJECTS)

$(OUT)/get_opts.s: \
		get_opts.jn
	${CATPILE}

$(OUT)/Graph.s: \
		Graph.jn
	${CATPILE}

$(OUT)/graph_to_dot.s: \
		$(OUT)/Graph.jnh \
		graph_to_dot.jn
	${CATPILE}

include ../makefile.inc
