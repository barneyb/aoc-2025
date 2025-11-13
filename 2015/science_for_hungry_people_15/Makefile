YEAR = 2015
DAY = 15
include ../../make_vars.inc
PROG = $(BIN)/science_for_hungry_people
OBJECTS = \
	$(LIB)/StringBuilder.ext.o \

all: $(PROG) input.txt
	$(PROG) < input.txt

# this is ... inelegant. but it works!
$(OUT)/science_for_hungry_people.s: \
		$(OUT)/allocator.jstd.jnh \
		$(OUT)/io.jstd.jnh \
		$(OUT)/sys.jstd.jnh \
		$(OUT)/math.jstd.jnh \
		$(OUT)/string.jstd.jnh \
		$(OUT)/StringBuilder.ext.jnh \
 	 	$(OUT)/StringBuilder.jstd.jnh \
 	 	science_for_hungry_people.jn
	${CATPILE}

$(OUT)/StringBuilder.ext.s: \
		$(OUT)/allocator.jstd.jnh \
		$(OUT)/string.jstd.jnh \
 	 	$(OUT)/StringBuilder.jstd.jnh \
 	 	StringBuilder.ext.jn
	${CATPILE}

include ../../makefile.inc
