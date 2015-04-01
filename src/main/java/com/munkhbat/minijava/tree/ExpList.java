package com.munkhbat.minijava.tree;

import com.munkhbat.minijava.tree.exp.Exp;

public class ExpList {
  public Exp head;
  public ExpList tail;
  public ExpList(Exp h, ExpList t) {head=h; tail=t;}
}



