package com.munkhbat.minijava.tree.stm;

import com.munkhbat.minijava.tree.exp.ExpList;

abstract public class Stm {
	abstract public ExpList kids();
	abstract public Stm build(ExpList kids);
}

