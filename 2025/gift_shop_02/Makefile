YEAR = 2025
DAY = 2
NAME = gift_shop
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \

all: $(PROG) input.txt
	time $(PROG) < input.txt

$(OUT)/gift_shop.s: \
		gift_shop.jn
	${CATPILE}

include ../../makefile.inc
