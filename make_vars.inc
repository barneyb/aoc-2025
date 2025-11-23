TGT ?= target
BIN ?= $(TGT)/bin
LIB ?= $(TGT)/lib
OUT ?= $(TGT)/out
UTIL ?= ../../util
GRAPHVIZ_LAYOUT ?= dot
JNC ?= $(JOHANN_HOME)/bin/jnc
JSTDLIB ?= $(JOHANN_HOME)/lib/jstdlib.o
JSTDLIB_SRC ?= $(JOHANN_HOME)/jstdlib

define CATPILE
	@mkdir -p $(OUT)
	cat $^ > $*.jni
	$(JNC) --strict < $*.jni > $@
endef

define HEADPILE
	@mkdir -p $(OUT)
	$(JNC) --header < $< > $@
	@# compile the header (a no-op) to ensure validity
	$(JNC) < $@ > /dev/null
endef
