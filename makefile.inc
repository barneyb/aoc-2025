TGT = target
BIN = $(TGT)/bin
LIB = $(TGT)/lib
OUT = $(TGT)/out
JNC = $(JOHANN_HOME)/bin/jnc
JSTDLIB = $(JOHANN_HOME)/lib/jstdlib.o

# blindly assume that whatever includes this defines 'all' as its entrypoint
__default__: all

input.txt:
	aocd $(YEAR) $(DAY) > /tmp/input.txt && mv /tmp/input.txt input.txt

$(BIN)/%: $(LIB)/%.o $(JSTDLIB)
	@mkdir -p $(BIN)
	gcc $^ -o $@

$(LIB)/%.o: $(OUT)/%.s
	@mkdir -p $(LIB)
	gcc -c $< -o $@

$(OUT)/%.s: %.jn $(JNC)
	@mkdir -p $(OUT)
	$(JNC) < $< > $@

clean:
	rm -rf $(TGT)

# don't delete intermediate files created by pattern rules
.SECONDARY:
# never clean up partially-compiled assembly files (with errors)
.PRECIOUS: $(OUT)/*.s
