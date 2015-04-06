package com.munkhbat.minijava.tree.exp;


public class BINOP extends IRExp {
	public int binop;
	public IRExp left, right;
	
	public BINOP(int b, IRExp l, IRExp r) {
		binop=b; 
		left=l;
		right=r; 
	}
	public final static int PLUS=0, MINUS=1, MUL=2, DIV=3, 
			AND=4,OR=5,LSHIFT=6,RSHIFT=7,ARSHIFT=8,XOR=9;
	
	public IRExpList kids() {
		return new IRExpList(left, new IRExpList(right,null));
	}
	
	public IRExp build(IRExpList kids) {
		return new BINOP(binop,kids.head,kids.tail.head);
	}
}

