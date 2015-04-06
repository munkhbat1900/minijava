package com.munkhbat.minijava.tree.exp;

public class CONST extends IRExp {
	public int value;
	public CONST(int v) {value=v;}
	public IRExpList kids() {return null;}
	public IRExp build(IRExpList kids) {return this;}
}

