package com.munkhbat.minijava.tree.stm;

import com.munkhbat.minijava.temp.Label;
import com.munkhbat.minijava.temp.LabelList;
import com.munkhbat.minijava.tree.exp.IRExp;
import com.munkhbat.minijava.tree.exp.IRExpList;
import com.munkhbat.minijava.tree.exp.NAME;

public class JUMP extends IRStm {
	public IRExp exp;
	public LabelList targets;
	public JUMP(IRExp e, LabelList t) {exp=e; targets=t;}
	
	public JUMP(Label target) {
		this(new NAME(target), new LabelList(target,null));
	}
	
	public IRExpList kids() {return new IRExpList(exp,null);}
	
	public IRStm build(IRExpList kids) {
		return new JUMP(kids.head,targets);
	}
}

