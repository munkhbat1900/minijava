package com.munkhbat.minijava.tree;

import com.munkhbat.minijava.tree.exp.Exp;

public class EXP extends Stm {
  public Exp exp; 
  public EXP(Exp e) {exp=e;}
  public ExpList kids() {return new ExpList(exp,null);}
  public Stm build(ExpList kids) {
    return new EXP(kids.head);
  }
}

