package com.munkhbat.minijava.ast;

import com.munkhbat.minijava.visitor.TypeVisitor;
import com.munkhbat.minijava.visitor.Visitor;

public class Program {
  public MainClass m;
  public ClassDeclList cl;

  public Program(MainClass am, ClassDeclList acl) {
    m=am; cl=acl; 
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Type accept(TypeVisitor v) {
    return v.visit(this);
  }
}
