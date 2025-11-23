YEAR = 2016
DAY = 16
include ../../make_vars.inc
OBJECTS = \

all: $(BIN)/dragon_checksum input.txt
	time $(BIN)/dragon_checksum 272 < input.txt
	time $(BIN)/dragon_checksum 35651584 < input.txt

ex1: $(BIN)/dragon_checksum
	$(BIN)/dragon_checksum 2 1
	$(BIN)/dragon_checksum 2 0
	$(BIN)/dragon_checksum 6 11111
	$(BIN)/dragon_checksum 13 111100001010
	$(BIN)/dragon_checksum 20 10000

include ../../makefile.inc
