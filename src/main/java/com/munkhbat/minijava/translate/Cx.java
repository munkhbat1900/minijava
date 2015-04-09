package com.munkhbat.minijava.translate;

import com.munkhbat.minijava.temp.Label;
import com.munkhbat.minijava.temp.Temp;
import com.munkhbat.minijava.tree.IRTreeFactory;
import com.munkhbat.minijava.tree.exp.ESEQ;
import com.munkhbat.minijava.tree.exp.IRExp;
import com.munkhbat.minijava.tree.exp.TEMP;
import com.munkhbat.minijava.tree.stm.IRStm;
import com.munkhbat.minijava.tree.stm.LABEL;
import com.munkhbat.minijava.tree.stm.MOVE;
import com.munkhbat.minijava.tree.stm.SEQ;

public abstract class Cx extends Exp {

	@Override
	IRExp unEx() {
		Temp r = new Temp();
		Label t = new Label();
		Label f = new Label();
		return new ESEQ(
				new SEQ(new MOVE(new TEMP(r), IRTreeFactory.TRUE), 
						new SEQ(unCx(t, f),
								new SEQ(new LABEL(f),
										new SEQ(
												new MOVE(new TEMP(r), IRTreeFactory.FALSE),
												new LABEL(t))))),
				new TEMP(r));
	}

	@Override
	IRStm unNx() {
		// TODO Auto-generated method stub
		return null;
	}
	
	abstract IRStm unCx(Label t, Label f);

}
