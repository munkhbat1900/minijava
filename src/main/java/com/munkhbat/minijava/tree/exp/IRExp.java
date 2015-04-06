package com.munkhbat.minijava.tree.exp;

public abstract class IRExp {
	public abstract IRExpList kids();
	
	public abstract IRExp build(IRExpList kids);
}


