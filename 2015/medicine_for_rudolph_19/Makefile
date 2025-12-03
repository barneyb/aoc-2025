YEAR=2015
DAY=19
include ../../make_vars.inc
PROG = $(BIN)/medicine_for_rudolph

all: $(PROG) input.txt
	time $(PROG) < input.txt

ex1: $(PROG)
	$(PROG) < example_1.txt

ex2: $(PROG)
	$(PROG) < example_2.txt

include ../../makefile.inc
