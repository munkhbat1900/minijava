package com.munkhbat.minijava.typecheck;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.munkhbat.minijava.ast.Type;

/**
 * this class is from from http://alumni.cs.ucr.edu/~vladimir/cs152/A5/SymbolTable.java
 */
public class Method {
	String id;
	Type type;
	List<Variable> params;
	Hashtable<Object, Variable> vars;

	/**
	 * @param id method name
	 * @param type return type
	 */
	public Method(String id, Type type) {
		this.id = id;
		this.type = type;
		vars = new Hashtable<Object, Variable>();
		params = new ArrayList<Variable>();
	}

	public String getId() { return id; }

	public Type type() { return type; }


	/**
	 * adds argument
	 * @param id
	 * @param type
	 * @return
	 */
	public boolean addParam(String id, Type type) {
		if(containsParam(id)) 
			return false;       
		else {
			params.add(new Variable(id, type));
			return true;
		}
	}

	public Variable getParamAt(int i){
		if (i<params.size())
			return params.get(i);
		else
			return null;
	}

	
	/**
	 * adds local variable
	 * @param id
	 * @param type
	 * @return
	 */
	public boolean addVar(String id, Type type) {
		if(vars.containsKey(id)) 
			return false;
		else{
			vars.put(id, new Variable(id, type));
			return true;
		}
	}

	public boolean containsVar(String id) {
		return vars.containsKey(id);
	}

	public boolean containsParam(String id) {
		for (int i = 0; i< params.size(); i++)
			if ((params.get(i)).id.equals(id))
				return true;
		return false;
	}

	public Variable getVar(String id) {
		if(containsVar(id)) 
			return (Variable)vars.get(id);
		else 
			return null;
	}

	public Variable getParam(String id) {

		for (int i = 0; i< params.size(); i++)
			if (((Variable)params.get(i)).id.equals(id))
				return (Variable)(params.get(i));

		return null;
	}
}
