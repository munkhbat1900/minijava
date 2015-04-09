package com.munkhbat.minijava.translate;

import com.munkhbat.minijava.temp.Label;
import com.munkhbat.minijava.tree.exp.IRExp;
import com.munkhbat.minijava.tree.stm.IRStm;

/**
 * @author munkhbat
 * Ex stands for an "expression" represented as tree exp
 * Nx stands for “no result,” represented as a Tree statement.
 * Cx stands for “conditional,” represented as a function from label-pair to 
 * statement. If you pass it a true destination and a false destination,
 *  it will make a statement that evaluates some conditionals and then jumps to one of the
 *  destinations
 */
public abstract class Exp {
	abstract IRExp unEx();
	abstract IRStm unNx();
	/**
	 * @param t true destination
	 * @param f false destination
	 * @return
	 */
	abstract IRStm unCx(Label t, Label f);
}
