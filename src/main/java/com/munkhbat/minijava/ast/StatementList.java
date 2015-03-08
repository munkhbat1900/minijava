package com.munkhbat.minijava.ast;

import java.util.ArrayList;

public class StatementList {
   private ArrayList<Statement> list;

   public StatementList() {
      list = new ArrayList<Statement>();
   }

   public void addElement(Statement n) {
      list.add(n);
   }

   public Statement elementAt(int i)  { 
      return list.get(i); 
   }

   public int size() { 
      return list.size(); 
   }
}
