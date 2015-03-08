package com.munkhbat.minijava.typecheck;

import java.util.ArrayList;

import com.munkhbat.minijava.ast.And;
import com.munkhbat.minijava.ast.ArrayAssign;
import com.munkhbat.minijava.ast.ArrayLength;
import com.munkhbat.minijava.ast.ArrayLookup;
import com.munkhbat.minijava.ast.Assign;
import com.munkhbat.minijava.ast.Block;
import com.munkhbat.minijava.ast.BooleanType;
import com.munkhbat.minijava.ast.Call;
import com.munkhbat.minijava.ast.ClassDeclExtends;
import com.munkhbat.minijava.ast.ClassDeclSimple;
import com.munkhbat.minijava.ast.False;
import com.munkhbat.minijava.ast.Formal;
import com.munkhbat.minijava.ast.Identifier;
import com.munkhbat.minijava.ast.IdentifierExp;
import com.munkhbat.minijava.ast.IdentifierType;
import com.munkhbat.minijava.ast.If;
import com.munkhbat.minijava.ast.IntArrayType;
import com.munkhbat.minijava.ast.IntegerLiteral;
import com.munkhbat.minijava.ast.IntegerType;
import com.munkhbat.minijava.ast.LessThan;
import com.munkhbat.minijava.ast.MainClass;
import com.munkhbat.minijava.ast.MethodDecl;
import com.munkhbat.minijava.ast.Minus;
import com.munkhbat.minijava.ast.NewArray;
import com.munkhbat.minijava.ast.NewObject;
import com.munkhbat.minijava.ast.Not;
import com.munkhbat.minijava.ast.Plus;
import com.munkhbat.minijava.ast.Print;
import com.munkhbat.minijava.ast.Program;
import com.munkhbat.minijava.ast.This;
import com.munkhbat.minijava.ast.Times;
import com.munkhbat.minijava.ast.True;
import com.munkhbat.minijava.ast.Type;
import com.munkhbat.minijava.ast.VarDecl;
import com.munkhbat.minijava.ast.While;
import com.munkhbat.minijava.visitor.TypeVisitor;

public class TypeCheckerVisitor implements TypeVisitor {
	private SymbolTable symbolTable;
	private ArrayList<String> error;
	private Class currentClass = null;
	private Method currentMethod = null;

	public TypeCheckerVisitor(SymbolTable symbolTable, ArrayList<String> error) {
		this.symbolTable = symbolTable;
		this.error = error;
	}

	@Override
	public Type visit(Program n) {
		n.m.accept(this);
		for ( int i = 0; i < n.cl.size(); i++ ) 
		{
			n.cl.elementAt(i).accept(this);
		}
		return null;
	}

	@Override
	public Type visit(MainClass n) {
		//		n.i1.accept(this);
		currentClass = symbolTable.getClass(n.i1.s);
		//		n.i2.accept(this);
		n.s.accept(this);
		return null;
	}

	@Override
	public Type visit(ClassDeclSimple n) {
		//		n.i.accept(this);
		currentClass = symbolTable.getClass(n.i.s);
		for ( int i = 0; i < n.vl.size(); i++ ) {
			n.vl.elementAt(i).accept(this);
		}
		for ( int i = 0; i < n.ml.size(); i++ ) {
			n.ml.elementAt(i).accept(this);
		}
		return new IdentifierType(n.i.s);
	}

	@Override
	public Type visit(ClassDeclExtends n) {
		//		n.i.accept(this);
		currentClass = symbolTable.getClass(n.i.s);
		//		n.j.accept(this);

		if (symbolTable.getClass(n.j.s) == null) {
			error.add("parent class " + n.j.s + " is not defined.");
		}

		for ( int i = 0; i < n.vl.size(); i++ ) {
			n.vl.elementAt(i).accept(this);
		}
		for ( int i = 0; i < n.ml.size(); i++ ) {
			n.ml.elementAt(i).accept(this);
		}
		return null;
	}

	@Override
	public Type visit(VarDecl n) {
		//		n.t.accept(this);
		//		n.i.accept(this);
		return null;
	}

	@Override
	public Type visit(MethodDecl n) {
		n.t.accept(this);
		//		n.i.accept(this);
		currentMethod = currentClass.getMethod(n.i.s);
		for ( int i = 0; i < n.fl.size(); i++ ) {
			n.fl.elementAt(i).accept(this);
		}
		for ( int i = 0; i < n.vl.size(); i++ ) {
			n.vl.elementAt(i).accept(this);
		}
		for ( int i = 0; i < n.sl.size(); i++ ) {
			n.sl.elementAt(i).accept(this);
		}
		n.e.accept(this);
		return null;
	}

	@Override
	public Type visit(Formal n) {
		//		n.t.accept(this);
		//		n.i.accept(this);
		return null;
	}

	@Override
	public Type visit(IntArrayType n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visit(BooleanType n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visit(IntegerType n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visit(IdentifierType n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visit(Block n) {
		for ( int i = 0; i < n.sl.size(); i++ ) {
			n.sl.elementAt(i).accept(this);
		}
		return null;
	}

	@Override
	public Type visit(If n) {
		Type t1 = n.e.accept(this);
		if (!(t1 instanceof BooleanType)) {
			error.add("if statement condition must be of type boolean" + currentClass.id);
		}

		n.s1.accept(this);
		n.s2.accept(this);
		return null;
	}

	@Override
	public Type visit(While n) {
		Type t1 = n.e.accept(this);
		if (!(t1 instanceof BooleanType)) {
			error.add("while loop condition must be of type boolean" + currentClass.id);
		}
		n.s.accept(this);
		return null;
	}

	@Override
	public Type visit(Print n) {
		Type t1 = n.e.accept(this);
		if (!(t1 instanceof IntegerType)) {
			error.add("System.out.println takes argument of int type." + currentClass.id);
		}
		return null;
	}

	@Override
	public Type visit(Assign n) {
		Type t1 = n.i.accept(this);
		Type t2 = n.e.accept(this);
		if (!symbolTable.compareTypes(t1, t2)) {
			if (!isSubType(t2, t1)) {
				error.add("left side and right side of the assign must be of same type. " + currentClass.id + " " + n.i.s);
			}
		}
		return null;
	}
	
	/**
	 * checks whether or not ty1 is subtype of ty2.
	 * @param ty1
	 * @param ty2
	 * @return
	 */
	private boolean isSubType(Type ty1, Type ty2) {
		if (!(ty1 instanceof IdentifierType)) {
			return false;
		}
		if (!(ty2 instanceof IdentifierType)) {
			return false;
		}
		
		IdentifierType type1 = (IdentifierType)ty1;
		IdentifierType type2 = (IdentifierType)ty2;
		
		Class classt1 = symbolTable.getClass(type1.s);
		Class classt2 = symbolTable.getClass(type2.s);
		
		Class tmpClass = classt1;
		while (tmpClass.parent() != null) {
			if (tmpClass.parent().equals(classt2.id)) {
				return true;
			}
			tmpClass = symbolTable.getClass(tmpClass.parent());
		}
		return false;
	}

	@Override
	public Type visit(ArrayAssign n) {
		Type t1 = n.i.accept(this);
		Type t2 = n.e1.accept(this);
		Type t3 = n.e2.accept(this);

		if (!(t1 instanceof IntArrayType)) {
			error.add("identifier must be of array type. " + currentClass.id);
		}

		if (!(t2 instanceof IntegerType)) {
			error.add("array index must be type of int." + currentClass.id);
		}
		if (!(t3 instanceof IntegerType)) {
			error.add("value assigned to array must be type of int" + currentClass.id);
		}

		return null;
	}

	@Override
	public Type visit(And n) {
		Type t1 = n.e1.accept(this);
		Type t2 = n.e2.accept(this);

		if (!(t1 instanceof BooleanType)) {
			error.add("left side of the && must be type of boolean." + currentClass.id);
		}
		if (!(t2 instanceof BooleanType)) {
			error.add("right side of the && must be type of boolean" + currentClass.id);
		}
		return new BooleanType();
	}

	@Override
	public Type visit(LessThan n) {
		Type t1 = n.e1.accept(this);
		Type t2 = n.e2.accept(this);

		if (!(t1 instanceof IntegerType)) {
			error.add("left side of the < must be type of integer." + currentClass.id);
		}
		if (!(t2 instanceof IntegerType)) {
			error.add("right side of the > must be type of integer" + currentClass.id);
		}

		return new BooleanType();
	}

	@Override
	public Type visit(Plus n) {
		Type t1 = n.e1.accept(this);
		Type t2 = n.e2.accept(this);
		if (!(t1 instanceof IntegerType)) {
			error.add("left side of the plus must be type of integer." + currentClass.id);
		}
		if (!(t2 instanceof IntegerType)) {
			error.add("right side of the plus must be type of integer" + currentClass.id);
		}
		return new IntegerType();
	}

	@Override
	public Type visit(Minus n) {
		Type t1 = n.e1.accept(this);
		Type t2 = n.e2.accept(this);
		if (!(t1 instanceof IntegerType)) {
			error.add("left side of the Minus must be type of integer." + currentClass.id);
		}
		if (!(t2 instanceof IntegerType)) {
			error.add("right side of the Minus must be type of integer" + currentClass.id);
		}
		return new IntegerType();
	}

	@Override
	public Type visit(Times n) {
		Type t1 = n.e1.accept(this);
		Type t2 = n.e2.accept(this);
		if (!(t1 instanceof IntegerType)) {
			error.add("left side of the Times must be type of integer." + currentClass.id);
		}
		if (!(t2 instanceof IntegerType)) {
			error.add("right side of the Times must be type of integer" + currentClass.id);
		}
		return new IntegerType();
	}

	@Override
	public Type visit(ArrayLookup n) {
		Type t1 = n.e1.accept(this);
		Type t2 = n.e2.accept(this);

		if (!(t1 instanceof IntArrayType)) {
			error.add("id must be array of int." + currentClass.id);
		}
		if (!(t2 instanceof IntegerType)) {
			error.add("arraylookup expression must be integer." + currentClass.id);
		}

		return new IntegerType();
	}

	@Override
	public Type visit(ArrayLength n) {
		Type type = n.e.accept(this);
		if (!(type instanceof IntArrayType)) {
			error.add("length only applies to int[]" + currentClass.id);
		}
		return new IntegerType();
	}
	
	private Method getMethodIncludingSubType(Class clas, String methodId) {
		Class tmpClass = clas;
		while (tmpClass != null) {
			Method method = tmpClass.getMethod(methodId);
			if (method != null) {
				return method;
			}
			tmpClass = symbolTable.getClass(tmpClass.parent());
		}
		return null;
	}

	@Override
	public Type visit(Call n) {
		IdentifierType objectType = null;
		try {
			objectType = (IdentifierType)n.e.accept(this);
		} catch(ClassCastException e) {
			error.add("it is not class type. " + currentClass.id + " " + n.e.accept(this));
			return null;
		}

		if (objectType == null) {
			error.add("object is not declared in method call expression");
			return null;
		}

		Class clas = symbolTable.getClass(objectType.s);
		Method method = getMethodIncludingSubType(clas, n.i.s);
		
		if (method == null) {
			error.add("there is no such method in " + objectType.s + "." + n.i.s);
		}

		if (n.el.size() != method.params.size()) {
			error.add("method argument count does not match." + objectType.s + "." + method.id);
			return null;
		}

		for ( int i = 0; i < n.el.size(); i++ ) {
			Type t1 = n.el.elementAt(i).accept(this);
			if (!symbolTable.compareTypes(method.getParamAt(i).type, t1)) {
				error.add("method argument type does not match." + objectType.s + "." + method.id);
				break;
			}
		}
		return method.type;
	}

	@Override
	public Type visit(IntegerLiteral n) {
		return new IntegerType();
	}

	@Override
	public Type visit(True n) {
		return new BooleanType();
	}

	@Override
	public Type visit(False n) {
		return new BooleanType();
	}

	@Override
	public Type visit(IdentifierExp n) {
		return getType(n.s);
	}

	@Override
	public Type visit(This n) {
		return new IdentifierType(currentClass.id);
	}

	@Override
	public Type visit(NewArray n) {
		Type type = n.e.accept(this);
		if (!(type instanceof IntegerType)) {
			error.add("array size must be type of integer type." + currentClass.id);
		}
		return new IntArrayType();
	}

	@Override
	public Type visit(NewObject n) {
		return new IdentifierType(n.i.s);
	}

	@Override
	public Type visit(Not n) {
		Type type = n.e.accept(this);
		if (!(type instanceof BooleanType)) {
			error.add("reverse operator takes boolean value." + currentClass.id);
		}
		return new BooleanType();
	}

	@Override
	public Type visit(Identifier n) {
		return getType(n.s);
	}

	private Type getType(String id) {
		if (currentMethod != null) {
			Variable variable = currentMethod.getParam(id);
			if (variable != null) {
				return variable.type;
			}

			variable = currentMethod.getVar(id);
			if (variable != null) {
				return variable.type;
			}

			variable = currentClass.getVar(id);
			if (variable != null) {
				return variable.type;
			}
			error.add("identifier " + id + " is not defined in " + currentClass.id + "." + currentMethod.id);
		} else if (currentClass != null){
			Variable variable = currentClass.getVar(id);
			if (variable != null) {
				return variable.type;
			}
			error.add("identifier " + id + " is not defined in " + currentClass.id);
			return null;
		}
		return null;
	}

}
