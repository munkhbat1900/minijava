package com.munkhbat.minijava.ast;

import com.munkhbat.minijava.visitor.TypeVisitor;
import com.munkhbat.minijava.visitor.Visitor;

public class While extends Statement {
  public Exp e;
  public Statement s;

  public While(Exp ae, Statement as) {
    e=ae; s=as; 
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Type accept(TypeVisitor v) {
    return v.visit(this);
  }
}

