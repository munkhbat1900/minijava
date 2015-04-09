package com.munkhbat.minijava.translate;

import com.munkhbat.minijava.temp.Label;
import com.munkhbat.minijava.tree.exp.IRExp;
import com.munkhbat.minijava.tree.stm.EXP;
import com.munkhbat.minijava.tree.stm.IRStm;

/**
 * @author munkhbat
 * class for an ordinary expression that yields single value.
 */
public class Ex extends Exp {
	private IRExp irExp;
	
	public Ex(IRExp irExp) {
		this.irExp = irExp;
	}
	
	@Override
	IRExp unEx() {
		return irExp;
	}

	@Override
	IRStm unNx() {
		return new EXP(irExp);
	}

	@Override
	IRStm unCx(Label t, Label f) {
		// TODO Auto-generated method stub
		return null;
	}

}
