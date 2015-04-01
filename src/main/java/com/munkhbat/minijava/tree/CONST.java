package com.munkhbat.minijava.tree;

import com.munkhbat.minijava.tree.exp.Exp;

public class CONST extends Exp {
  public int value;
  public CONST(int v) {value=v;}
  public ExpList kids() {return null;}
  public Exp build(ExpList kids) {return this;}
}

