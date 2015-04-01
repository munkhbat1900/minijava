package com.munkhbat.minijava.tree;

import com.munkhbat.minijava.temp.Temp;
import com.munkhbat.minijava.tree.exp.Exp;

public class TEMP extends Exp {
	public Temp temp;
	public TEMP(Temp t) {temp=t;}
	public ExpList kids() {return null;}
	public Exp build(ExpList kids) {return this;}
}

