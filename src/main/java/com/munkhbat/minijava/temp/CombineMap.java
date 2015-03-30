package com.munkhbat.minijava.temp;

public class CombineMap implements TempMap {

	TempMap tMap1, tMap2;
	
	@Override
	public String tempMap(Temp t) {
		String s = tMap1.tempMap(t);
		if (s != null) {
			return s;
		}
		return tMap2.tempMap(t);
	}

}
