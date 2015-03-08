package com.munkhbat.minijava.typecheck;

import com.munkhbat.minijava.ast.Type;

/**
 * this class is from from http://alumni.cs.ucr.edu/~vladimir/cs152/A5/SymbolTable.java
 * it represents variable.
 */
public class Variable {
	String id;
	Type type;

	public Variable(String id, Type type) {
		this.id = id;
		this.type = type;
	}

	public String id() { return id; }

	public Type type() { return type; }
}
