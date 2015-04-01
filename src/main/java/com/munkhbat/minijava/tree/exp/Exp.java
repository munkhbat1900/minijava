package com.munkhbat.minijava.tree.exp;

public abstract class Exp {
	public abstract ExpList kids();
	
	public abstract Exp build(ExpList kids);
}
