package com.munkhbat.minijava.ast;

import com.munkhbat.minijava.visitor.TypeVisitor;
import com.munkhbat.minijava.visitor.Visitor;

public abstract class Exp {
  public abstract void accept(Visitor v);
  public abstract Type accept(TypeVisitor v);
}
