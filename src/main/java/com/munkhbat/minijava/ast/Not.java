package com.munkhbat.minijava.ast;

import com.munkhbat.minijava.tree.IRVisitor;
import com.munkhbat.minijava.tree.exp.IRExp;
import com.munkhbat.minijava.visitor.TypeVisitor;
import com.munkhbat.minijava.visitor.Visitor;

public class Not extends Exp {
	public Exp e;

	public Not(Exp ae) {
		e=ae; 
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public Type accept(TypeVisitor v) {
		return v.visit(this);
	}

	@Override
	public IRExp accept(IRVisitor v) {
		return v.visit(this);
	}
}
