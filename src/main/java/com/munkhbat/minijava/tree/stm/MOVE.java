package com.munkhbat.minijava.tree.stm;

import com.munkhbat.minijava.tree.exp.IRExp;
import com.munkhbat.minijava.tree.exp.IRExpList;
import com.munkhbat.minijava.tree.exp.MEM;

public class MOVE extends IRStm {
	public IRExp dst, src;
	
	/**
	 * evaluates s and move it to d
	 * @param d
	 * @param s
	 */
	public MOVE(IRExp d, IRExp s) {dst=d; src=s;}
	public IRExpList kids() {
		if (dst instanceof MEM)
			return new IRExpList(((MEM)dst).exp, new IRExpList(src,null));
		else return new IRExpList(src,null);
	}
	public IRStm build(IRExpList kids) {
		if (dst instanceof MEM)
			return new MOVE(new MEM(kids.head), kids.tail.head);
		else return new MOVE(dst, kids.head);
	}
}

