package com.munkhbat.minijava.frame;

import com.munkhbat.minijava.temp.Temp;
import com.munkhbat.minijava.tree.exp.IRExp;
import com.munkhbat.minijava.tree.exp.TEMP;

public class InReg extends Access {
	private Temp temp;
	
	public InReg(Temp temp) {
		this.temp = temp;
	}

	@Override
	public IRExp exp(IRExp framePtr) {
		return new TEMP(temp);
	}
}
