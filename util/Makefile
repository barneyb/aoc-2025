include ../make_vars.inc
OBJECTS = \
	$(LIB)/get_opts.o \
	$(LIB)/Graph.o \
	$(LIB)/graph_to_dot.o \

all: $(OBJECTS)

$(OUT)/graph_to_dot.s: \
		$(OUT)/Graph.jnh \
		graph_to_dot.jn
	${CATPILE}

include ../makefile.inc

verify: all
	@#

input.txt:
	@#
