package com.munkhbat.minijava.tree.exp;


/**
 * @author munkhbat
 * The contents of wordSize bytes of memory starting at address e
 * Note that when MEM is used as the left child of a MOVE,
 * it means “store,” but anywhere else it means “fetch.”
 */
public class MEM extends IRExp {
	public IRExp exp;
	public MEM(IRExp e) {exp=e;}
	public IRExpList kids() {return new IRExpList(exp,null);}
	public IRExp build(IRExpList kids) {
		return new MEM(kids.head);
	}
}

