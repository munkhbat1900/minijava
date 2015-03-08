package com.munkhbat.minijava.ast;

import java.util.ArrayList;
import java.util.List;

public class ExpList {
   private List<Exp> list;

   public ExpList() {
      list = new ArrayList<Exp>();
   }

   public void addElement(Exp n) {
      list.add(n);
   }

   public Exp elementAt(int i)  { 
      return list.get(i); 
   }

   public int size() { 
      return list.size(); 
   }
}
