package com.munkhbat.minijava.tree.exp;

import com.munkhbat.minijava.tree.stm.IRStm;

public class ESEQ extends IRExp {
  public IRStm stm;
  public IRExp exp;
  public ESEQ(IRStm s, IRExp e) {stm=s; exp=e;}
  public IRExpList kids() {throw new Error("kids() not applicable to ESEQ");}
  public IRExp build(IRExpList kids) {throw new Error("build() not applicable to ESEQ");}
}

