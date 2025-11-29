YEAR = 2019
DAY = 3
NAME = crossed_wires
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \
	$(LIB)/Input.o \
	$(LIB)/Instructions.o \
	$(LIB)/Points.o \

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG) ex1.txt
	$(PROG) < ex1.txt

ex2: $(PROG) ex2.txt
	$(PROG) < ex2.txt

ex3: $(PROG) ex3.txt
	$(PROG) < ex3.txt

$(OUT)/crossed_wires.s: \
		$(OUT)/Input.jnh \
		$(OUT)/Instructions.jnh \
		$(OUT)/Points.jnh \
		crossed_wires.jn
	${CATPILE}

include ../../makefile.inc
