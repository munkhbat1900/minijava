package com.munkhbat.minijava.translate;

import com.munkhbat.minijava.temp.Label;
import com.munkhbat.minijava.tree.exp.IRExp;
import com.munkhbat.minijava.tree.stm.IRStm;

/**
 * @author munkhbat
 * class for an expression that yields no value
 */
public class Nx extends Exp {
	private IRStm irStm;
	
	public Nx(IRStm irStm) {
		this.irStm = irStm;
	}
	
	@Override
	IRExp unEx() {
		return null;
	}

	@Override
	IRStm unNx() {
		return irStm;
	}

	@Override
	IRStm unCx(Label t, Label f) {
		return null;
	}

}
