package com.munkhbat.minijava.ast;
import com.munkhbat.minijava.tree.IRVisitor;
import com.munkhbat.minijava.tree.exp.IRExp;
import com.munkhbat.minijava.visitor.TypeVisitor;
import com.munkhbat.minijava.visitor.Visitor;

public class ArrayLookup extends Exp {
	public Exp e1,e2;

	public ArrayLookup(Exp ae1, Exp ae2) { 
		e1=ae1; e2=ae2;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public Type accept(TypeVisitor v) {
		return v.visit(this);
	}
	
	public IRExp accept(IRVisitor v) {
		return v.visit(this);
	}
}
