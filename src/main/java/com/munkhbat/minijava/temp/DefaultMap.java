package com.munkhbat.minijava.temp;

public class DefaultMap implements TempMap {

	public DefaultMap() {
	}
	
	@Override
	public String tempMap(Temp t) {
		return t.toString();
	}

}
