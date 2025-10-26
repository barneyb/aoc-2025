JNC = $(JOHANN_HOME)/bin/jnc
JSTDLIB = $(JOHANN_HOME)/lib/jstdlib.o

all: ./*
	@$$JOHANN_HOME/bin/jnc --version
	@for dir in $$(find . -name Makefile -mindepth 2); do \
    	echo ; \
    	echo $$(dirname "$$dir") ; \
    	$(MAKE) -C $$(dirname "$$dir") clean all ; \
    	echo ; \
	done
