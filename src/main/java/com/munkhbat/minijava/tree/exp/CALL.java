package com.munkhbat.minijava.tree.exp;


public class CALL extends IRExp {
	public IRExp func;
	public IRExpList args;
	public CALL(IRExp f, IRExpList a) {func=f; args=a;}
	public IRExpList kids() {return new IRExpList(func,args);}
	public IRExp build(IRExpList kids) {
		return new CALL(kids.head,kids.tail);
	}

}

