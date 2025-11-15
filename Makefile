JNC = $(JOHANN_HOME)/bin/jnc
JSTDLIB = $(JOHANN_HOME)/lib/jstdlib.o

all: ./*
	@$$JOHANN_HOME/bin/jnc --version
	@for dir in $$(find . -name Makefile -mindepth 2); do \
    	echo ; \
    	echo $$(dirname "$$dir") ; \
    	pushd $$(dirname "$$dir") > /dev/null ; \
    	$(MAKE) clean all ; \
    	time $(MAKE) ; \
    	popd > /dev/null ; \
    	echo ; \
	done
