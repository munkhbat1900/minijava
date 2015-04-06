package com.munkhbat.minijava.ast;

import com.munkhbat.minijava.tree.IRVisitor;
import com.munkhbat.minijava.tree.exp.IRExp;
import com.munkhbat.minijava.visitor.TypeVisitor;
import com.munkhbat.minijava.visitor.Visitor;

public abstract class Statement {
	public abstract void accept(Visitor v);
	public abstract Type accept(TypeVisitor v);
	public abstract IRExp accept(IRVisitor v);
}
