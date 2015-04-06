package com.munkhbat.minijava.ast;

import com.munkhbat.minijava.tree.IRVisitor;
import com.munkhbat.minijava.visitor.TypeVisitor;
import com.munkhbat.minijava.visitor.Visitor;

public abstract class ClassDecl {
	public abstract void accept(Visitor v);
	public abstract Type accept(TypeVisitor v);
	public abstract void accept(IRVisitor v); 
}
