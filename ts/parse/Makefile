#
# check if parser needs to be rebuilt
#
# also contains target for generating class files for parser in this directory
# this is used with the gui.sh, tokens.sh and tree.sh scripts that run the
#   parser in debug mode.
#

TscriptParser.java: Tscript.g4
	bash buildParser.sh

debug: Tscript.g4
	bash buildParserForDebugging.sh
	../../../build/bin/jc *.java
	touch debug

clean:
	/bin/rm -f TscriptParser.java Tscript.tokens TscriptLexer.java TscriptLexer.tokens TscriptListener.java TscriptBaseListener.java *.class debug

