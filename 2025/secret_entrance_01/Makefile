YEAR = 2025
DAY = 1
NAME = secret_entrance
include ../../make_vars.inc
PROG = $(BIN)/$(NAME)
OBJECTS = \

all: $(PROG) input.txt
	time $(PROG) < input.txt

$(OUT)/secret_entrance.s: \
		secret_entrance.jn
	${CATPILE}

include ../../makefile.inc
