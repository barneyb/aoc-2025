YEAR = 2016
DAY = 16
include ../../make_vars.inc
PROG = $(BIN)/dragon_checksum
OBJECTS = \

all: $(PROG) input.txt
	time $(PROG) 272 < input.txt
	time $(PROG) 35651584 < input.txt

ex1: $(PROG)
	$(PROG) 2 1
	$(PROG) 2 0
	$(PROG) 6 11111
	$(PROG) 13 111100001010
	$(PROG) 20 10000

include ../../makefile.inc

verify:
	time $(PROG) 272 < input.txt | ../../verify.sh $(YEAR) $(DAY)
	time $(PROG) 35651584 < input.txt | ../../verify.sh $(YEAR) $(DAY)
