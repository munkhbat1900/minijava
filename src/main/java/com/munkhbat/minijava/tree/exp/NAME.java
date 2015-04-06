package com.munkhbat.minijava.tree.exp;

import com.munkhbat.minijava.temp.Label;

public class NAME extends IRExp {
	public Label label;
	public NAME(Label l) {label=l;}
	public IRExpList kids() {return null;}
	public IRExp build(IRExpList kids) {return this;}
}

