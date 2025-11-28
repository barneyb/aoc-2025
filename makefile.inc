# the util folder is only one deep, so use the "optional" leading dash
-include ../../make_vars.inc

# blindly assume that whatever includes this defines 'all' as its entrypoint
__default__: all

input.txt: ~/.config/aocd/token
	aocd $(YEAR) $(DAY) > /tmp/input.txt && mv /tmp/input.txt input.txt

clean: clean_internal
	rm -rf $(TGT) input.txt

# nothing, by default
clean_internal:

# allow arbitrary handoff to utils
# not sure why both FORCE and .PHONY are needed, but it doesn't work otherwise
$(UTIL)/%: FORCE
	$(MAKE) -C $(UTIL) $*

FORCE:

.PHONY: FORCE

# main build targets
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

%: $(BIN)/%
	$(BIN)/$@

# for programs capable of generating DOT files
%.dot: %.txt $(PROG)
	$(PROG) --dot < $< > $@

%.$(GRAPHVIZ_LAYOUT).svg: %.dot
	$(GRAPHVIZ_LAYOUT) -o$@ -Tsvg $<

# don't delete intermediate files created by pattern rules
.SECONDARY:
# never clean up partially-compiled assembly files (with errors)
.PRECIOUS: $(OUT)/*.s
