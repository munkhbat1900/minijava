package com.munkhbat.minijava.tree.stm;

import com.munkhbat.minijava.tree.exp.IRExp;
import com.munkhbat.minijava.tree.exp.IRExpList;

public class EXP extends IRStm {
	public IRExp exp; 
	public EXP(IRExp e) {
		exp=e;
	}
	
	public IRExpList kids() {
		return new IRExpList(exp,null);
	}
	
	public IRStm build(IRExpList kids) {
		return new EXP(kids.head);
	}
}

