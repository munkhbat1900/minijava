package com.munkhbat.minijava.visitor;

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

public class DepthFirstVisitor implements Visitor {

  // MainClass m;
  // ClassDeclList cl;
  public void visit(Program n) {
    n.m.accept(this);
    for ( int i = 0; i < n.cl.size(); i++ ) {
        n.cl.elementAt(i).accept(this);
    }
  }
  
  // Identifier i1,i2;
  // Statement s;
  public void visit(MainClass n) {
    n.i1.accept(this);
    n.i2.accept(this);
    n.s.accept(this);
  }
  
  // Identifier i;
  // VarDeclList vl;
  // MethodDeclList ml;
  public void visit(ClassDeclSimple n) {
    n.i.accept(this);
    for ( int i = 0; i < n.vl.size(); i++ ) {
        n.vl.elementAt(i).accept(this);
    }
    for ( int i = 0; i < n.ml.size(); i++ ) {
        n.ml.elementAt(i).accept(this);
    }
  }
 
  // Identifier i;
  // Identifier j;
  // VarDeclList vl;
  // MethodDeclList ml;
  public void visit(ClassDeclExtends n) {
    n.i.accept(this);
    n.j.accept(this);
    for ( int i = 0; i < n.vl.size(); i++ ) {
        n.vl.elementAt(i).accept(this);
    }
    for ( int i = 0; i < n.ml.size(); i++ ) {
        n.ml.elementAt(i).accept(this);
    }
  }

  // Type t;
  // Identifier i;
  public void visit(VarDecl n) {
    n.t.accept(this);
    n.i.accept(this);
  }

  // Type t;
  // Identifier i;
  // FormalList fl;
  // VarDeclList vl;
  // StatementList sl;
  // Exp e;
  public void visit(MethodDecl n) {
    n.t.accept(this);
    n.i.accept(this);
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

  // Type t;
  // Identifier i;
  public void visit(Formal n) {
    n.t.accept(this);
    n.i.accept(this);
  }

  public void visit(IntArrayType n) {
  }

  public void visit(BooleanType n) {
  }

  public void visit(IntegerType n) {
  }

  // String s;
  public void visit(IdentifierType n) {
  }

  // StatementList sl;
  public void visit(Block n) {
    for ( int i = 0; i < n.sl.size(); i++ ) {
        n.sl.elementAt(i).accept(this);
    }
  }

  // Exp e;
  // Statement s1,s2;
  public void visit(If n) {
    n.e.accept(this);
    n.s1.accept(this);
    n.s2.accept(this);
  }

  // Exp e;
  // Statement s;
  public void visit(While n) {
    n.e.accept(this);
    n.s.accept(this);
  }

  // Exp e;
  public void visit(Print n) {
    n.e.accept(this);
  }
  
  // Identifier i;
  // Exp e;
  public void visit(Assign n) {
    n.i.accept(this);
    n.e.accept(this);
  }

  // Identifier i;
  // Exp e1,e2;
  public void visit(ArrayAssign n) {
    n.i.accept(this);
    n.e1.accept(this);
    n.e2.accept(this);
  }

  // Exp e1,e2;
  public void visit(And n) {
    n.e1.accept(this);
    n.e2.accept(this);
  }

  // Exp e1,e2;
  public void visit(LessThan n) {
    n.e1.accept(this);
    n.e2.accept(this);
  }

  // Exp e1,e2;
  public void visit(Plus n) {
    n.e1.accept(this);
    n.e2.accept(this);
  }

  // Exp e1,e2;
  public void visit(Minus n) {
    n.e1.accept(this);
    n.e2.accept(this);
  }

  // Exp e1,e2;
  public void visit(Times n) {
    n.e1.accept(this);
    n.e2.accept(this);
  }

  // Exp e1,e2;
  public void visit(ArrayLookup n) {
    n.e1.accept(this);
    n.e2.accept(this);
  }

  // Exp e;
  public void visit(ArrayLength n) {
    n.e.accept(this);
  }

  // Exp e;
  // Identifier i;
  // ExpList el;
  public void visit(Call n) {
    n.e.accept(this);
    n.i.accept(this);
    for ( int i = 0; i < n.el.size(); i++ ) {
        n.el.elementAt(i).accept(this);
    }
  }

  // int i;
  public void visit(IntegerLiteral n) {
  }

  public void visit(True n) {
  }

  public void visit(False n) {
  }

  // String s;
  public void visit(IdentifierExp n) {
  }

  public void visit(This n) {
  }

  // Exp e;
  public void visit(NewArray n) {
    n.e.accept(this);
  }

  // Identifier i;
  public void visit(NewObject n) {
  }

  // Exp e;
  public void visit(Not n) {
    n.e.accept(this);
  }

  // String s;
  public void visit(Identifier n) {
  }
}
