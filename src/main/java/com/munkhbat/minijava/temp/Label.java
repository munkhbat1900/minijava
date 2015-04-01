package com.munkhbat.minijava.temp;

import com.munkhbat.minijava.typecheck.Symbol;

/**
 * @author munkhbat
 * label represents location whose exact address yet to be determined. 
 * it is like label in assembly language
 */
public class Label {
	private String name;
	private static int count;

	/**
	 * a printable representation of label, for use in assembly language output. 
	 */
	@Override
	public String toString(){
		return name;
	}

	/**
	 * Makes a new label that prints as "name".
	 * Warning: avoid repeated calls to <tt>new Label(s)</tt> with
	 * the same name <tt>s</tt>.
	 */
	public Label(String n) {
		name=n;
	}

	/**
	 * Makes a new label with an arbitrary name.
	 */
	public Label() {
		this("L" + count++);
	}

	/**
	 * Makes a new label whose name is the same as a symbol.
	 */
	public Label(Symbol s) {
		this(s.toString());
	}
}
