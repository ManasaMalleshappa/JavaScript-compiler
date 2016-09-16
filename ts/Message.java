/**
 * central location for generating standardized error messages.
 *
 */

package ts;

/**
 * Group of static fields and methods that the system uses to generate
 * standardized error messages.
 */
public final class Message {
	// should not be instantiated
	private Message() {
	}

	private static int errorCount = 0;

	private static boolean doLogging = false;

	private static int lineNumber = 0;

	// terminate the program
	private static void terminateByThrow() {
		throw new RuntimeException("program terminated");
	}

	private static void terminateByExit() {
		System.exit(1);
	}

	/**
	 * Record current location during evaluation of the AST.
	 *
	 * @param line
	 *            current line number
	 */
	public static void setLineNumber(final int line) {
		lineNumber = line;
	}

	/**
	 * Emit message for an error during evaluation and then exit.
	 *
	 * @param message
	 *            message string to be printed
	 */
	public static void executionError(final String message) {
		System.err.printf("%d: %s\n", lineNumber, message);
		terminateByExit();
	}

	/**
	 * Emit message for a syntax error and then exit. Must be passed the
	 * location because this class only tracks Location during AST evaluation.
	 *
	 * @param loc
	 *            location (filename and line) of error
	 */
	public static void syntaxError(final Location loc) {
		System.err.printf("%d: syntax error (column %d)\n", loc.line, loc.column);
		// parser stops with first syntax error so this method exits program
		terminateByExit();
	}

	/**
	 * Emit message for a semantic error. Must be passed the location because
	 * this class only tracks Location during AST evaluation.
	 *
	 * @param loc
	 *            location (filename and line) of error
	 * @param message
	 *            message string to be printed
	 */
	public static void error(final Location loc, final String message) {
		errorCount += 1;
		// just displaying the line number for now
		System.err.printf("%d: %s\n", loc.line, message);
	}

	/**
	 * Emit a message for a fatal user error, such as bad source file name.
	 *
	 * @param message
	 *            message string to be printed
	 */
	public static void fatal(final String message) {
		System.err.println(message);
		terminateByExit();
	}

	/**
	 * Return count of number of semantic errors detected.
	 *
	 * @return the number of semantic errors detected
	 */
	public static int getErrorCount() {
		return errorCount;
	}

	/** Turn on logging of compiler developer messages. */
	public static void enableLogging() {
		doLogging = true;
	}

	/**
	 * Log (emit) compiler developer message (if enabled)
	 *
	 * @param message
	 *            message string to be printed
	 */
	public static void log(String message) {
		if (doLogging) {
			System.err.printf("LOG: %s\n", message);
		}
	}

	/**
	 * Emit a message for an internal compiler error.
	 *
	 * @param loc
	 *            location (filename and line) of error
	 * @param message
	 *            message string to be printed
	 */
	public static void bug(final Location loc, final String message) {
		System.err.printf("BUG %d: %s\n", loc.line, message);
		terminateByThrow();
	}

	/**
	 * Emit a message for an internal compiler error without a Location.
	 *
	 * @param message
	 *            message string to be printed
	 */
	public static void bug(final String message) {
		System.err.printf("BUG: %s\n", message);
		terminateByThrow();
	}

	/** Emit the "usage" message for running the system. */
	public static void usage() {
		fatal("Usage: ts [-AST] [-log] [-noexec] [-java] file.ts");
	}
}
