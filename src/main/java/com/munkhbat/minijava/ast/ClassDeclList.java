package com.munkhbat.minijava.ast;

import java.util.ArrayList;
import java.util.List;

public class ClassDeclList {
   private List<ClassDecl> list;

   public ClassDeclList() {
      list = new ArrayList<ClassDecl>();
   }

   public void addElement(ClassDecl n) {
      list.add(n);
   }

   public ClassDecl elementAt(int i)  { 
      return list.get(i); 
   }

   public int size() { 
      return list.size(); 
   }
}
