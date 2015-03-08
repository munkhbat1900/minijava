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
import com.munkhbat.minijava.ast.VarDecl;
import com.munkhbat.minijava.ast.While;
import com.munkhbat.minijava.visitor.Visitor;

public class SymbolTableBuilder implements Visitor {

	SymbolTable symbolTable = new SymbolTable();
	Class currentClass = null;
	Method currentMethod = null;

	private ArrayList<String> error;

	public ArrayList<String> getErrors() {
		return error;
	}

	public SymbolTable buildSymbolTable(Program n) {
		error = new ArrayList<>();
		this.visit(n);
		return symbolTable;
	}

	@Override
	public void visit(Program n) {
		n.m.accept(this);
		for (int i = 0; i < n.cl.size(); i++) {
			n.cl.elementAt(i).accept(this);
		}
	}

	@Override
	public void visit(MainClass n) {
		n.i1.accept(this);
		n.i2.accept(this);
		if (!symbolTable.addClass(n.i1.s, null)) {
			error.add("main class" + n.i1.s + " is already defined");
		}

		currentClass = symbolTable.getClass(n.i1.s);

		n.s.accept(this);
	}

	@Override
	public void visit(ClassDeclSimple n) {
		n.i.accept(this);
		if (!symbolTable.addClass(n.i.s, null)) {
			error.add("simple class " + n.i.s + " is already defined");
		}

		currentClass = symbolTable.getClass(n.i.s);

		for ( int i = 0; i < n.vl.size(); i++ ) {
			n.vl.elementAt(i).accept(this);
		}
		for ( int i = 0; i < n.ml.size(); i++ ) {
			n.ml.elementAt(i).accept(this);
		}

	}

	@Override
	public void visit(ClassDeclExtends n) {
		n.i.accept(this);
		n.j.accept(this);

		if (!symbolTable.addClass(n.i.s, n.j.s)) {
			error.add("class " + n.i.s + " is already defined");
		}

		currentClass = symbolTable.getClass(n.i.s);

		for ( int i = 0; i < n.vl.size(); i++ ) {
			n.vl.elementAt(i).accept(this);
		}
		for ( int i = 0; i < n.ml.size(); i++ ) {
			n.ml.elementAt(i).accept(this);
		}
	}

	@Override
	public void visit(VarDecl n) {
		n.t.accept(this);
		n.i.accept(this);

		if (currentMethod == null) {
			if (!currentClass.addVar(n.i.s, n.t)) {
				error.add(n.i.s + " is already defined in " + currentClass.id);
			}
		} else if (!currentMethod.addVar(n.i.s, n.t)) {
			error.add(n.i.s + " is already defined in " + currentClass.id + "." + currentMethod.id);
		}
	}

	@Override
	public void visit(MethodDecl n) {
		n.t.accept(this);
		n.i.accept(this);

		if (!currentClass.addMethod(n.i.s, n.t)) {
			error.add("method " + n.i.s + " is already defined in " + currentClass.id);
		}

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
	}

	@Override
	public void visit(Formal n) {
		n.t.accept(this);
		n.i.accept(this);
		if (!currentMethod.addParam(n.i.s, n.t)) {
			error.add("parameter " + n.i.s + " is already defined in " + currentClass.id + "." + currentMethod.id);
		}
	}

	@Override
	public void visit(IntArrayType n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(BooleanType n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IntegerType n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IdentifierType n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Block n) {
		for ( int i = 0; i < n.sl.size(); i++ ) {
			n.sl.elementAt(i).accept(this);
		}
	}

	@Override
	public void visit(If n) {
		n.e.accept(this);
		n.s1.accept(this);
		n.s2.accept(this);
	}

	@Override
	public void visit(While n) {
		n.e.accept(this);
		n.s.accept(this);
	}

	@Override
	public void visit(Print n) {
		n.e.accept(this);
	}

	@Override
	public void visit(Assign n) {
		n.i.accept(this);
		n.e.accept(this);
	}

	@Override
	public void visit(ArrayAssign n) {
		n.i.accept(this);
		n.e1.accept(this);
		n.e2.accept(this);
	}

	@Override
	public void visit(And n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	@Override
	public void visit(LessThan n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	@Override
	public void visit(Plus n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	@Override
	public void visit(Minus n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	@Override
	public void visit(Times n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	@Override
	public void visit(ArrayLookup n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	@Override
	public void visit(ArrayLength n) {
		n.e.accept(this);
	}

	@Override
	public void visit(Call n) {
		n.e.accept(this);
		n.i.accept(this);
		for ( int i = 0; i < n.el.size(); i++ ) {
			n.el.elementAt(i).accept(this);
		}
	}

	@Override
	public void visit(IntegerLiteral n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(True n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(False n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IdentifierExp n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(This n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(NewArray n) {
		n.e.accept(this);
	}

	@Override
	public void visit(NewObject n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Not n) {
		n.e.accept(this);
	}

	@Override
	public void visit(Identifier n) {
		// TODO Auto-generated method stub

	}

}
