package com.munkhbat.minijava.tree.exp;

import com.munkhbat.minijava.temp.Temp;

public class TEMP extends IRExp {
	public Temp temp;
	public TEMP(Temp t) {temp=t;}
	public IRExpList kids() {return null;}
	public IRExp build(IRExpList kids) {return this;}
}

