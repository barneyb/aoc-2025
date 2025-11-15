include ../../make_vars.inc

# blindly assume that whatever includes this defines 'all' as its entrypoint
__default__: all

input.txt:
	aocd $(YEAR) $(DAY) > /tmp/input.txt && mv /tmp/input.txt input.txt

clean:
	rm -rf $(TGT) input.txt

$(BIN)/%: $(LIB)/%.o $(JSTDLIB) $(OBJECTS)
	@mkdir -p $(BIN)
	gcc $^ -o $@

$(LIB)/%.o: $(OUT)/%.s
	@mkdir -p $(LIB)
	gcc -c $< -o $@

$(OUT)/%.s: %.jn $(JNC)
	@mkdir -p $(OUT)
	$(JNC) < $< > $@

$(OUT)/%.jnh: %.jn $(JNC)
	${HEADPILE}

$(OUT)/%.jstd.jnh: $(JSTDLIB_SRC)/%.jn $(JNC)
	${HEADPILE}

%: $(BIN)/%
	$(BIN)/$@

# don't delete intermediate files created by pattern rules
.SECONDARY:
# never clean up partially-compiled assembly files (with errors)
.PRECIOUS: $(OUT)/*.s
