package com.munkhbat.minijava.tree.stm;

import com.munkhbat.minijava.temp.Label;
import com.munkhbat.minijava.tree.exp.IRExpList;

public class LABEL extends IRStm { 
  public Label label;
  public LABEL(Label l) {label=l;}
  public IRExpList kids() {return null;}
  public IRStm build(IRExpList kids) {
    return this;
  }
}

