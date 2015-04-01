package com.munkhbat.minijava.tree.stm;

import com.munkhbat.minijava.temp.Label;
import com.munkhbat.minijava.tree.exp.ExpList;

public class LABEL extends Stm { 
  public Label label;
  public LABEL(Label l) {label=l;}
  public ExpList kids() {return null;}
  public Stm build(ExpList kids) {
    return this;
  }
}

