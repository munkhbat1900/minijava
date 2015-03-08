package com.munkhbat.minijava.typecheck;

import java.util.Dictionary;
import java.util.Hashtable;

public class Symbol {
	private String name;
	private static Dictionary<String, Symbol> dict = new Hashtable<String, Symbol>();
	
	private Symbol(String n) {
		name = n;
	}
	
	public String toString() {
		return name;
	}
	
	public static Symbol symbol(String n) {
		String u = n.intern();
		Symbol s = dict.get(u);
		if (s == null) {
			s = new Symbol(u);
			dict.put(u, s);
		}
		return s;
	}
	
}
