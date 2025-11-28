YEAR = 2015
DAY = 15
include ../../make_vars.inc
PROG = $(BIN)/science_for_hungry_people
OBJECTS = \

all: $(PROG) input.txt
	time $(PROG) < input.txt

$(OUT)/science_for_hungry_people.s: \
 	 	science_for_hungry_people.jn
	${CATPILE}

include ../../makefile.inc
