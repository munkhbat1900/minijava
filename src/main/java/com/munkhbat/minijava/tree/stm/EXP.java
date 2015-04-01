package com.munkhbat.minijava.tree.stm;

import com.munkhbat.minijava.tree.exp.Exp;
import com.munkhbat.minijava.tree.exp.ExpList;

public class EXP extends Stm {
  public Exp exp; 
  public EXP(Exp e) {exp=e;}
  public ExpList kids() {return new ExpList(exp,null);}
  public Stm build(ExpList kids) {
    return new EXP(kids.head);
  }
}

