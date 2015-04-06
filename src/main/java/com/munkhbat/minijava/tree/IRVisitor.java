package com.munkhbat.minijava.tree;

import com.munkhbat.minijava.ast.And;
import com.munkhbat.minijava.ast.ArrayAssign;
import com.munkhbat.minijava.ast.ArrayLength;
import com.munkhbat.minijava.ast.ArrayLookup;
import com.munkhbat.minijava.ast.Assign;
import com.munkhbat.minijava.ast.Block;
import com.munkhbat.minijava.ast.Call;
import com.munkhbat.minijava.ast.ClassDeclExtends;
import com.munkhbat.minijava.ast.ClassDeclSimple;
import com.munkhbat.minijava.ast.False;
import com.munkhbat.minijava.ast.Formal;
import com.munkhbat.minijava.ast.Identifier;
import com.munkhbat.minijava.ast.IdentifierExp;
import com.munkhbat.minijava.ast.If;
import com.munkhbat.minijava.ast.IntegerLiteral;
import com.munkhbat.minijava.ast.LessThan;
import com.munkhbat.minijava.ast.MainClass;
import com.munkhbat.minijava.ast.MethodDecl;
import com.munkhbat.minijava.ast.Minus;
import com.munkhbat.minijava.ast.NewArray;
import com.munkhbat.minijava.ast.NewObject;
import com.munkhbat.minijava.ast.Not;
import com.munkhbat.minijava.ast.Plus;
import com.munkhbat.minijava.ast.Program;
import com.munkhbat.minijava.ast.This;
import com.munkhbat.minijava.ast.Times;
import com.munkhbat.minijava.ast.True;
import com.munkhbat.minijava.ast.VarDecl;
import com.munkhbat.minijava.ast.While;
import com.munkhbat.minijava.tree.exp.BINOP;
import com.munkhbat.minijava.tree.exp.IRExp;

public class IRVisitor {
	public IRExp visit(And exp) {
		return new BINOP(BINOP.AND, exp.e1.accept(this), exp.e2.accept(this));
	}

	public IRExp visit(ArrayAssign exp) {
		return null;
	}

	public IRExp visit(ArrayLength exp) {
		return null;
	}

	public IRExp visit(ArrayLookup exp) {
		return null;
	}

	public IRExp visit(Assign exp) {
		return null;
	}

	public IRExp visit(Block exp) {
		return null;
	}

	public IRExp visit(Call exp) {
		return null;
	}

	public void visit(ClassDeclExtends exp) {

	}

	public void visit(ClassDeclSimple exp) {

	}
	
	public IRExp visit(False exp) {
		return null;
	}
	
	public IRExp visit(Formal exp) {
		return null;
	}
	
	public IRExp visit(Identifier exp) {
		return null;
	}
	
	public IRExp visit(IdentifierExp exp) {
		return null;
	}
	
	public IRExp visit(If exp) {
		return null;
	}
	
	public IRExp visit(IntegerLiteral exp) {
		return null;
	}
	
	public IRExp visit(LessThan exp) {
		return null;
	}
	
	public void visit(MainClass exp) {
		
	}
	
	public void visit(MethodDecl exp) {
		
	}
	
	public IRExp visit(Minus exp) {
		return null;
	}
	
	public IRExp visit(NewArray exp) {
		return null;
	}
	
	public IRExp visit(NewObject exp) {
		return null;
	}
	
	public IRExp visit(Not exp) {
		return null;
	}
	
	public IRExp visit(Plus exp) {
		return null;
	}
	
	public IRExp visit(com.munkhbat.minijava.ast.Print exp) {
		return null;
	}
	
	public void visit(Program exp) {
		
	}
	
	public IRExp visit(This exp) {
		return null;
	}
	
	public IRExp visit(Times exp) {
		return null;
	}
	
	public IRExp visit(True exp) {
		return null;
	}
	
	public IRExp visit(VarDecl exp) {
		return null;
	}
	
	public IRExp visit(While exp) {
		return null;
	}
}
