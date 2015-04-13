package com.munkhbat.minijava.frame;

import com.munkhbat.minijava.tree.exp.IRExp;

/**
 * @author munkhbat
 * this class describes formals and locals that maybe in frame or in register
 */
public abstract class Access {
	/**
	 * turn Acess into IR tree exp
	 * @param framePtr
	 * @return
	 */
	public abstract IRExp exp(IRExp framePtr);
}
