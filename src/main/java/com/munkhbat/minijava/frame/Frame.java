package com.munkhbat.minijava.frame;

import com.munkhbat.minijava.temp.Label;
import com.munkhbat.minijava.tree.exp.TEMP;
import com.munkhbat.minijava.util.BoolList;

public abstract class Frame {
	private Label name;
	/**
	 * generates new frame
	 * @param name method name
	 * @param formals whether formal parameters escape or not
	 * @return
	 */
	public abstract Frame newFrame(Label name, BoolList formals);
	
	public abstract TEMP FP();
	public abstract int wordSize();
}
