package com.munkhbat.minijava.tree.exp;


public class MEM extends IRExp {
	public IRExp exp;
	public MEM(IRExp e) {exp=e;}
	public IRExpList kids() {return new IRExpList(exp,null);}
	public IRExp build(IRExpList kids) {
		return new MEM(kids.head);
	}
}

