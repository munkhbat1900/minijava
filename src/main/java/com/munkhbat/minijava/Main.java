package com.munkhbat.minijava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.munkhbat.minijava.ast.Program;
import com.munkhbat.minijava.parser.MiniJavaParser;
import com.munkhbat.minijava.parser.ParseException;
import com.munkhbat.minijava.typecheck.SymbolTable;
import com.munkhbat.minijava.typecheck.SymbolTableBuilder;
import com.munkhbat.minijava.typecheck.TypeCheckerVisitor;
import com.munkhbat.minijava.visitor.PrettyPrintVisitor;

public class Main {
	public static void main(String[] arguments) {
		String pathname = "src/test/typetest/Factorial.java";
		Program program = null;
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(pathname))));
			
			MiniJavaParser miniJavaParser = new MiniJavaParser(br);
			program = miniJavaParser.Program(); 
			
			PrettyPrintVisitor prettyPrinter = new PrettyPrintVisitor();
			//prettyPrinter.visit(program);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		if (program == null) {
			System.out.println("program is null");
			System.exit(0);
		}
		
		// type checking phase
		SymbolTableBuilder builder = new SymbolTableBuilder();
		SymbolTable symbolTable = builder.buildSymbolTable(program);
		ArrayList<String> errors = builder.getErrors();
		
		TypeCheckerVisitor typeCheckerVisitor = new TypeCheckerVisitor(symbolTable, errors);
		typeCheckerVisitor.visit(program);
		
		for (String error : errors) {
			System.out.println(error);
		}
		
		if (errors.size() > 0) {
			System.exit(1);
		}
		
		// translate to intermediate code
	}
}
