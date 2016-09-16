/**
 * marks a location in the source code: embedded in AST nodes
 *
 */

package ts;

/**
 * Tracks a location in the source code: filename, line number and column.
 * Location references are stored in the AST by the parser.
 */
public final class Location {
	protected String path;
	protected int line;
	protected int column;

	/**
	 * Construct an object to record a source code location.
	 *
	 * @param path
	 *            path to the source file.
	 * @param line
	 *            the line number.
	 * @param column
	 *            the column number.
	 */
	public Location(final String path, final int line, final int column) {
		this.path = path;
		this.line = line;
		this.column = column;
	}

	/**
	 * Get the path to the location's source file.
	 *
	 * @return the path to the location's source file.
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Set the path field to contain the location's source file.
	 *
	 * @param path
	 *            the path to the location's source file.
	 */
	public void setPath(final String path) {
		this.path = path.replace('\\', '/');
	}

	/**
	 * Get the location's line number.
	 *
	 * @return the location's line number.
	 */
	public int getLine() {
		return line;
	}

	/**
	 * Set the line field to contain the location's line number.
	 *
	 * @param line
	 *            the location's line number.
	 */
	public void setLine(final int line) {
		this.line = line;
	}

	/**
	 * Get the location's column number.
	 *
	 * @return the location's column number.
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Set the column field to contain the location's column number.
	 *
	 * @param column
	 *            the location's column number.
	 */
	public void setColumn(final int column) {
		this.column = column;
	}
}
