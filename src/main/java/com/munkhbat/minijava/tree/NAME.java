package com.munkhbat.minijava.tree;

import com.munkhbat.minijava.temp.Label;
import com.munkhbat.minijava.tree.exp.Exp;

public class NAME extends Exp {
	public Label label;
	public NAME(Label l) {label=l;}
	public ExpList kids() {return null;}
	public Exp build(ExpList kids) {return this;}
}

