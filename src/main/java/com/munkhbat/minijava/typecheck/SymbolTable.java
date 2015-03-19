package com.munkhbat.minijava.typecheck;

import java.util.Hashtable;

import com.munkhbat.minijava.ast.BooleanType;
import com.munkhbat.minijava.ast.IdentifierType;
import com.munkhbat.minijava.ast.IntArrayType;
import com.munkhbat.minijava.ast.IntegerType;
import com.munkhbat.minijava.ast.Type;

/**
 * this class is from from http://alumni.cs.ucr.edu/~vladimir/cs152/A5/SymbolTable.java
 */
public class SymbolTable {
	private Hashtable<Object, Object> hashtable;

	public SymbolTable() {
		hashtable = new Hashtable<Object,Object>();
	}

	public boolean addClass(String id, String parent) {
		if(containsClass(id)) 
			return false;	    
		else 
			hashtable.put(id, new Class(id, parent));
		return true;	    
	}

	
	/**
	 * gets class declaration
	 * @param id
	 * @return
	 */
	public Class getClass(String id) {
		if(containsClass(id)) 
			return (Class)hashtable.get(id);	    
		else 
			return null;
	}

	private boolean containsClass(String id) {
		return hashtable.containsKey(id);
	}

	public Type getVarType(Method m, Class c, String id) {
		if(m != null) {
			if(m.getVar(id) != null) {
				return m.getVar(id).type();
			}
			if(m.getParam(id) != null){
				return m.getParam(id).type();
			}
		}

		while(c != null) {
			if(c.getVar(id) != null) {
				return c.getVar(id).type();
			}
			else {
				if(c.parent() == null) {
					c = null;
				}
				else {
					c = getClass(c.parent());
				}
			}
		}


		System.out.println("Variable " + id 
				+ " not defined in current scope");
		System.exit(0);
		return null;
	}

	public Method getMethod(String id, String classScope) {
		if(getClass(classScope)==null) {
			System.out.println("Class " + classScope 
					+ " not defined");  
			System.exit(0);
		}

		Class c = getClass(classScope);
		while(c != null) {
			if(c.getMethod(id) != null) {
				return c.getMethod(id);
			}
			else {
				if(c.parent() == null) {
					c = null;
				}
				else {
					c = getClass(c.parent());
				}
			}
		}


		System.out.println("Method " + id + " not defined in class " + classScope);

		System.exit(0);
		return null;
	}

	public Type getMethodType(String id, String classScope) {
		if(getClass(classScope)==null) {
			System.out.println("Class " + classScope 
					+ " not defined");  
			System.exit(0);
		}

		Class c = getClass(classScope);
		while(c != null) {
			if(c.getMethod(id) != null) {
				return c.getMethod(id).type();
			}
			else {
				if(c.parent() == null) {
					c = null;
				}
				else {
					c = getClass(c.parent());
				}
			}
		}

		System.out.println("Method " + id + " not defined in class " + classScope);	
		System.exit(0);
		return null;
	}

	public boolean compareTypes(Type t1, Type t2){

		if (t1 == null || t2 == null) return false;

		if (t1 instanceof IntegerType && t2 instanceof  IntegerType)
			return true;
		if (t1 instanceof BooleanType && t2 instanceof  BooleanType)
			return true;
		if (t1 instanceof IntArrayType && t2 instanceof IntArrayType)
			return true;
		if (t1 instanceof IdentifierType && t2 instanceof IdentifierType){
			IdentifierType i1 = (IdentifierType)t1;
			IdentifierType i2 = (IdentifierType)t2;

			Class c = getClass(i2.s);
			while(c != null) {
				if (i1.s.equals(c.getId())) return true;
				else {
					if(c.parent() == null) return false;
					c = getClass(c.parent());
				}
			}
		}
		return false;	
	}
}
