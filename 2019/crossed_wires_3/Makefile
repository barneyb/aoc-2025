YEAR = 2019
DAY = 3
NAME = crossed_wires
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \

all: $(PROG) input.txt
	time $(PROG) < input.txt

$(OUT)/crossed_wires.s: \
		crossed_wires.jn
	${CATPILE}

include ../../makefile.inc
