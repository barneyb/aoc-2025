JNC = $(JOHANN_HOME)/bin/jnc
JSTDLIB = $(JOHANN_HOME)/lib/jstdlib.o

all: ./*
	for dir in $$(find . -name Makefile -mindepth 2); do \
    	echo "$$dir" ; \
    	$(MAKE) -C $$(dirname "$$dir") clean all ; \
	done
