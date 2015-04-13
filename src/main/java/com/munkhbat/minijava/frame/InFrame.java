package com.munkhbat.minijava.frame;

import com.munkhbat.minijava.tree.exp.BINOP;
import com.munkhbat.minijava.tree.exp.CONST;
import com.munkhbat.minijava.tree.exp.IRExp;
import com.munkhbat.minijava.tree.exp.MEM;

public class InFrame extends Access {
	private int offset;
	
	public InFrame(int offset) {
		this.offset = offset;
	}

	@Override
	public IRExp exp(IRExp framePtr) {
		return new MEM(new BINOP(BINOP.PLUS, framePtr, new CONST(offset)));
	}
}
