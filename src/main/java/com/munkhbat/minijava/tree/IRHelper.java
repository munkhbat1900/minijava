package com.munkhbat.minijava.tree;

import com.munkhbat.minijava.temp.Label;
import com.munkhbat.minijava.tree.exp.*;
import com.munkhbat.minijava.tree.stm.*;

public class IRHelper {
	public static IRExp TRUE = new CONST(1);
	public static IRExp FALSE = new CONST(0);
	
	public static CALL CALL(Label f, IRExpList expList) {
		return new CALL(new NAME(f), expList);
	}
	
	public static IRExp BINOP(int op, IRExp l, IRExp r) {
		return new BINOP(op, l, r);
	}
}
