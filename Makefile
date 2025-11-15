JNC = $(JOHANN_HOME)/bin/jnc
JSTDLIB = $(JOHANN_HOME)/lib/jstdlib.o

all: ./*
	@$$JOHANN_HOME/bin/jnc --version
	@for dir in $$(find . -name Makefile -mindepth 2 | sort); do \
    	echo ; \
    	echo $$(dirname "$$dir") ; \
    	pushd $$(dirname "$$dir") > /dev/null ; \
    	$(MAKE) clean ; \
    	time $(MAKE) all ; \
    	popd > /dev/null ; \
    	echo ; \
	done
