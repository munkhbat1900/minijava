package com.munkhbat.minijava.tree.stm;

import com.munkhbat.minijava.tree.exp.IRExpList;

public class SEQ extends IRStm {
  public IRStm left, right;
  public SEQ(IRStm l, IRStm r) { left=l; right=r; }
  public IRExpList kids() {throw new Error("kids() not applicable to SEQ");}
  public IRStm build(IRExpList kids) {throw new Error("build() not applicable to SEQ");}
}

