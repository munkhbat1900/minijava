package com.munkhbat.minijava.tree.stm;

import com.munkhbat.minijava.tree.exp.IRExpList;

abstract public class IRStm {
	abstract public IRExpList kids();
	abstract public IRStm build(IRExpList kids);
}

