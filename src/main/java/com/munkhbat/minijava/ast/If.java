package com.munkhbat.minijava.ast;

import com.munkhbat.minijava.tree.IRVisitor;
import com.munkhbat.minijava.tree.exp.IRExp;
import com.munkhbat.minijava.visitor.TypeVisitor;
import com.munkhbat.minijava.visitor.Visitor;

public class If extends Statement {
	public Exp e;
	public Statement s1,s2;

	public If(Exp ae, Statement as1, Statement as2) {
		e=ae; s1=as1; s2=as2;
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

