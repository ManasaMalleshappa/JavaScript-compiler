#!/bin/bash

# script for invoking parser so that the token stream is dumped to stdout
#
# file to be parsed should be provided as stdin

# disable the JAVA_TOOL_OPTIONS environment variable that exists on agate
unset JAVA_TOOL_OPTIONS

make -s debug
../../../build/bin/grun Tscript program -tokens $@

